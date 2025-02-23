package com.example.shreeleathers.Controllers.POS;


import com.example.shreeleathers.Models.Master.GST;
import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Views.CartItemCellFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.ResourceBundle;

public class CheckoutController implements Initializable
{
    public Text payable_amount_lbl;
    public Text paid_amount_lbl;
    public Text round_off_lbl;
    public TextField cash_paid_txt;
    public TextField card_paid_txt;
    public TextField upi_paid_txt;
    public Button print_btn;
    public Button hold_btn;
    public Button save_btn;
    public Button modify_btn;
    public ListView<CartItems> items_listView;
    public double cashAmt;
    public double cardAmt;
    public double upiAmt;
    public double totalPaidAmt;
    public double totalAmt;
    public double roundOff;
    public ObservableList<CartItems> itemsList = FXCollections.observableArrayList();
    public Label return_rem_lbl;
    public String inv_No = null;
    public String customerName = null;
    public String customerContact = null;
    public TableColumn<GST, String> GST_column;
    public TableColumn<GST, String> amt_column;
    public TableView<GST> gst_tbl;
    public TableColumn<GST, Double> GSTper_column;
    public ObservableList<GST> gstDetails = FXCollections.observableArrayList();
    public String firmGSTN;
    public String custGSTN;
    public String user;
    public String firmName;
    public String add1;
    public String add2;
    public TableColumn<GST, String> GSTamt_col;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater(() -> cash_paid_txt.requestFocus());
        items_listView.setCellFactory(e -> new CartItemCellFactory());
        card_paid_txt.textProperty().addListener(observable -> setPaidDetails());
        cash_paid_txt.textProperty().addListener(observable -> setPaidDetails());
        upi_paid_txt.textProperty().addListener(observable -> setPaidDetails());
        print_btn.setOnAction(event -> generateBill());
    }

    private void calculateGSTSale()
    {
        if (custGSTN != null && !custGSTN.isEmpty() && firmGSTN != null && !firmGSTN.isEmpty() && !firmGSTN.substring(0, 2).equals(custGSTN.substring(0, 2)))
        {
            for (CartItems cartItems : itemsList)
            {
                int qty = cartItems.getQuantity();
                double rate = cartItems.getRate();
                double gst = Model.getInstance().getDatabaseDriver().getSaleDBServices().getGSTByCode(cartItems.getItemCode());
                updateGSTDetails(gst, rate, qty, "IGST");
            }
        }
        else
        {
            for (CartItems cartItems : itemsList)
            {
                int qty = cartItems.getQuantity();
                double rate = cartItems.getRate();
                double gst = Model.getInstance().getDatabaseDriver().getSaleDBServices().getGSTByCode(cartItems.getItemCode());
                updateGSTDetails(gst/2, rate, qty, "C_GST");
                updateGSTDetails(gst/2, rate, qty, "S_GST");
            }
        }
        GSTper_column.setCellValueFactory(cellData -> cellData.getValue().gstProperty().asObject());
        GST_column.setCellValueFactory(cellData -> cellData.getValue().gstTypeProperty());
        amt_column.setCellValueFactory(cellData -> cellData.getValue().taxableAmountProperty());
        GSTamt_col.setCellValueFactory(cellData -> cellData.getValue().gstAmountProperty());
        gst_tbl.setItems(gstDetails);
    }

    private void updateGSTDetails(double gst, double rate, int qty, String gstType)
    {
        boolean gstFound = false;

        for (GST detail : gstDetails)
        {
            if (detail.getGST() == gst && Objects.equals(detail.getGSTType(), gstType))
            {
                double amount = Double.parseDouble(detail.getTaxableAmount());
                double gstAmount = Double.parseDouble(detail.getGSTAmount());
                detail.setTaxableAmount(String.format("%.2f",((((100-gst)*qty*rate)/100)) + amount));
                detail.setGSTAmount(String.format("%.2f",(((gst*qty*rate)/100)) + gstAmount));
                gstFound = true;
                break;
            }
        }

        if (!gstFound)
        {
            gstDetails.add(new GST(gstType, gst, String.format("%.2f",((((100-gst)*qty*rate)/100))), String.format("%.2f",((((gst*qty*rate)/100))))));
        }
    }

    private void setPaidDetails()
    {
        if(cash_paid_txt.getText().isEmpty())
        {
            cash_paid_txt.setText("0");
        }
        if(card_paid_txt.getText().isEmpty())
        {
            card_paid_txt.setText("0");
        }
        if(upi_paid_txt.getText().isEmpty())
        {
            upi_paid_txt.setText("0");
        }
        cardAmt = Double.parseDouble(card_paid_txt.getText());
        cashAmt = Double.parseDouble(cash_paid_txt.getText());
        upiAmt = Double.parseDouble(upi_paid_txt.getText());
        totalPaidAmt = cardAmt + cashAmt + upiAmt;
        paid_amount_lbl.setText(String.format("%.2f",totalPaidAmt));
    }

    private void generateBill()
    {
        String payMode = null;
        double cashPaidAmt = 0.00;
        double cardPaidAmt = 0.00;
        double upiPaidAmt = 0.00;
        if(roundOff > 0)
        {
            FXMLLoader messageLoader = new FXMLLoader(getClass().getResource("/Fxml/MessageBox.fxml"));
            Model.getInstance().getViewFactory().showMessageBox(messageLoader, "");
            Model.getInstance().getMessageBoxController(messageLoader).giveError("Payment Error : Check Amount Paid");
        }
        else
        {
            if(Double.parseDouble(cash_paid_txt.getText()) != 0 )
            {
                payMode = payMode + "-CASH";
                cashPaidAmt = Double.parseDouble(cash_paid_txt.getText());
            }
            if(Double.parseDouble(card_paid_txt.getText()) != 0)
            {
                payMode = payMode + "-CARD";
                cardPaidAmt = Double.parseDouble(card_paid_txt.getText());
            }
            if(Double.parseDouble(upi_paid_txt.getText()) != 0)
            {
                payMode = payMode + "-UPI";
                upiPaidAmt = Double.parseDouble(upi_paid_txt.getText());
            }
            user = Model.getInstance().getUser().getName();
            System.out.println(user);
            Model.getInstance().getDatabaseDriver().getSaleDBServices().onSaleFunctions(itemsList, gstDetails, inv_No, customerName, customerContact, payMode, cashPaidAmt, cardPaidAmt, upiPaidAmt, user);
            Document document = new Document();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Bill");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            File file = fileChooser.showSaveDialog(new Stage());
            if(file != null)
            {
                try
                {
                    PdfWriter.getInstance(document, new FileOutputStream(file));
                    document.open();
//                    document.add(new Paragraph("Customer has purchased" + itemsList.size() + "items. Total Worth Rs." + totalAmt));

                    // Heading
                    String billTo = null;
                    Paragraph heading = new Paragraph(billTo + "\n**SREELEATHERS**\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
                    heading.setAlignment(Element.ALIGN_CENTER);
                    document.add(heading);
                    Paragraph firmDetails = new Paragraph(firmName + "\n" + add1 + "\n" + add2 + "\n" + "GST No.: " + firmGSTN, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
                    firmDetails.setAlignment(Element.ALIGN_CENTER);
                    document.add(firmDetails);
                    Paragraph heading2 = new Paragraph("**Proud to be at your service.**\nTAX-INVOICE\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
                    heading2.setAlignment(Element.ALIGN_CENTER);
                    document.add(heading2);
                    Paragraph custDetails = new Paragraph("Name: " + customerName + "Time: " + LocalTime.now() + "\nMobile No.: " + customerContact + "Date: " + LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
                    custDetails.setAlignment(Element.ALIGN_CENTER);
                    document.add(custDetails);

                    // Few lines gap
                    document.add(new Paragraph("\n\n"));

                    // Table
                    Paragraph invoiceNo = new Paragraph("Cash Memo No.: " + inv_No, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
                    PdfPTable table = new PdfPTable(9); // Number of columns
                    table.addCell("Sl");
                    table.addCell("#Item");
                    table.addCell("HSN");
                    table.addCell("Sz");
                    table.addCell("Gst");
                    table.addCell("Sm");
                    table.addCell("Qty");
                    table.addCell("Rate");
                    table.addCell("Amount");
                    // Add your items to the table
                    int i = 1;
                    double totalAmount = 0.00;
                    for (CartItems item : itemsList)
                    {
                        table.addCell(String.valueOf(i));
                        table.addCell(item.getItemCode());
                        table.addCell(Model.getInstance().getDatabaseDriver().getSaleDBServices().getHSNCodeByCode(item.getItemCode()));
                        table.addCell(item.getSize());
                        table.addCell(String.valueOf(Model.getInstance().getDatabaseDriver().getSaleDBServices().getGSTByCode(item.getItemCode())));
                        table.addCell(item.getSalesman());
                        table.addCell(String.valueOf(item.getQuantity()));
                        table.addCell(String.valueOf(item.getRate()));
                        table.addCell(String.format("%.2f", (item.getQuantity()*item.getRate())));
                        i = i+1;
                        totalAmount = totalAmount + Double.parseDouble(String.format("%.2f", (item.getRate()*item.getQuantity())));
                    }
                    document.add(table);
                    Paragraph amountDetails = new Paragraph("\nTotal: " + totalAmount + "\nTender Amount: " + paid_amount_lbl.getText() + "Refund: " + round_off_lbl.getText(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
                    amountDetails.setAlignment(Element.ALIGN_CENTER);
                    document.add(amountDetails);

                    document.add(new Paragraph("\n\n"));

                    PdfPTable gstTable = new PdfPTable(5); // Number of columns
                    table.addCell("Sl");
                    table.addCell("GST");
                    table.addCell("Taxable Amt");
                    table.addCell("%");
                    table.addCell("GST Amt");
                    // Add your items to the table
                    int j = 1;
                    for (GST details : gstDetails)
                    {
                        table.addCell(String.valueOf(j));
                        table.addCell(details.getGSTType());
                        table.addCell(details.getTaxableAmount());
                        table.addCell(String.valueOf(details.getGST()));
                        table.addCell(details.getGSTAmount());
                        i = i+1;
                    }
                    document.add(gstTable);
                    document.close();
                    if(Desktop.isDesktopSupported())
                    {
                        Desktop.getDesktop().open(file);
                    }
                    Stage checkoutStage = (Stage) items_listView.getScene().getWindow();
                    checkoutStage.close();
                    Platform.runLater(this::triggerSaleButton);
                }
                catch (DocumentException | IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private void triggerSaleButton() {
        // Get the instance of POSMenuController
        POSMenuController posMenuController = Model.getInstance().getPosMenuController();

        // Trigger the sale button click
        posMenuController.saleReturn_btn.fire();
        posMenuController.sale_btn.fire();
    }

    public void setData(ObservableList<CartItems> items, String invoiceNo, String custNm, String custNo, String custGST, String firmGST, String firmName, String add1, String add2)
    {
        inv_No = invoiceNo;
        customerName = custNm;
        customerContact = custNo;
        custGSTN = custGST;
        firmGSTN = firmGST;
        itemsList.addAll(items);
        items_listView.setItems(itemsList);
        this.firmName = firmName;
        this.add1 = add1;
        this.add2 = add2;
        calculateGSTSale();
    }

    public void setBillDetails(double payableAmount)
    {
        totalAmt = payableAmount;
        payable_amount_lbl.setText(String.format("%.2f", totalAmt));
    }

    public void setRoundOff(double payableAmount)
    {
        round_off_lbl.setText(payable_amount_lbl.getText());
        roundOff = Double.parseDouble(round_off_lbl.getText());
        paid_amount_lbl.textProperty().addListener((observableValue, oldVal, newVal) ->
        {
            roundOff = payableAmount - Double.parseDouble(newVal);
            if( roundOff > 0)
            {
                return_rem_lbl.setText("Remaining Amount:");
                round_off_lbl.setText(String.format("%.2f",roundOff));
            }
            else
            {
                return_rem_lbl.setText("Return Change:");
                round_off_lbl.setText(String.format("%.2f", roundOff));
            }
        });
    }
}

