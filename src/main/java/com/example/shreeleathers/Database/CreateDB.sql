
CREATE Account_Master (
    Acc_Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Acc_Code varchar(50) NOT NULL,
    Acc_Type varchar(10),
    Acc_Name varchar(100),
    Acc_Mobile varchar(11),
    Acc_Add_Line1 varchar(50),
    Acc_Add_Line2 varchar(50),
    State_Code varchar(10),
    City varchar(50),
    Pin_Code varchar(10),
    GST_Number varchar(50)
);
GO


CREATE TABLE Barcode_Mapping (
    Sl_Number bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Barcode_Length int NOT NULL,
    Field_name varchar(50) NOT NULL,
    Start_Index int NOT NULL,
    Field_Length int NOT NULL,
);
GO


CREATE TABLE Category_Master (
    Category_Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Category_Name varchar(100),
    GST float,
    HSN_Code varchar(50)
);
GO


CREATE TABLE Colour_Master (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Color_Desc varchar(20) NOT NULL
);
GO


CREATE TABLE Firm_Master (
    Firm_Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Firm_Name varchar(500) NOT NULL,
    Phone_Number varchar(11),
    Add_1 varchar(500),
    Add_2 varchar(500),
    City varchar(50),
    State varchar(50),
    State_Code varchar(10),
    Pin_Code varchar(50),
    GST_Number varchar(15)
)
GO

CREATE TABLE Invoice_Number_Log (
    Sl_No int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Date date NOT NULL,
    Prefix varchar(2) NOT NULL,
    Last_Invoice_Number char(15) NOT NULL,
    Financial_Year varchar(10) NOT NULL,
    FOREIGN KEY (Prefix) REFERENCES Prefix_Master(Prefix)
);
GO

CREATE TABLE Item_Inventory_Master (
    Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Trn_Date datetime,
    Particulars varchar(MAX),
    Item_Id int,
    Stock_In int DEFAULT 0,
    Stock_Out int DEFAULT 0,
    Row_Version timestamp,
    FOREIGN KEY (Item_Id) REFERENCES Item_Master(Item_Id)
    );
GO

CREATE TABLE Item_Master (
    Item_Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Item_Code varchar(15) NOT NULL,
    Category_Id int NOT NULL,
    Category varchar(100) NOT NULL,
    Item_Name varchar(100) NOT NULL,
    HSN_Code varchar(50) NOT NULL,
    Colour varchar(50),
    Size varchar(10) NOT NULL,
    Size_Id int NOT NULL,
    Purchase_Rate decimal(18,2) NOT NULL,
    GST_Purchased float NOT NULL,
    Sale_Rate decimal(18,2) NOT NULL,
    GST_Sale float NOT NULL,
    Disc_Per float NOT NULL,
    Status bit DEFAULT 1,
    Min_Stock int,
    FOREIGN KEY (Category_Id) REFERENCES Category_Master(Category_Id),
    FOREIGN KEY (Colour) REFERENCES Color_Master(Colour_Desc),
    FOREIGN KEY (Size_Id) REFERENCES Size_Master(Size_id),
    FOREIGN KEY (Item_Name) REFERENCES Item_Name_Master(Item_Name)
    );
GO

CREATE TABLE Item_Name_Master (
    Sl_Number int IDENTITY(1,1) NOT NULL,
    Category_Id int,
    Item_Name varchar(100) PRIMARY KEY NOT NULL,
    Size_Id int,
    Size_From varchar(10),
    Size_Upto varchar(10),
    FOREIGN KEY (Category_Id) REFERENCES Category_Master(Category_Id),
    FOREIGN KEY (Size_id) REFERENCES Size_Master(Size_Id)
    );
GO

CREATE TABLE Login_Details (
    User_Name varchar(50) PRIMARY KEY NOT NULL,
    Name varchar(50) NOT NULL,
    Password varchar(50) NOT NULL,
    Acc_Type varchar(50) NOT NULL,
    System-Assigned varchar(50) NOT NULL,
    Is_Active bit NOT NULL DEFAULT 1
    );
GO

CREATE TABLE Option_Switches (
    Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Stock_Date date NOT NULL,
    Allow_Bill_Zero_Stock bit NOT NULL DEFAULT 0,
    Gate_Pass bit NOT NULL DEFAULT 0,
    Skip_Qty bit NOT NULL DEFAULT 0,
    Print_Gst_Details bit NOT NULL DEFAULT 0,
    Dot_Matrix_Bill bit NOT NULL DEFAULT 0,
    Thermal_Bill bit NOT NULL DEFAULT 0,
    Max_Items_In_Sale bit NOT NULL DEFAULT 0,
    Print_Run_Date bit NOT NULL DEFAULT 0,
    Activate_Discount bit NOT NULL DEFAULT 0,
    Auto_Print_Sale_Bill bit NOT NULL DEFAULT 0,
    KColour varchar(50)
    );
GO

CREATE TABLE Payment_Mode_Details (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15),
    Inv_Date  date,
    Pay_Mode varchar(10),
    Amount decimal(18,2),
    FOREIGN KEY (Pay_Mode) REFERENCES Payment_Mode_Master (Payment_Mode),
    FOREIGN KEY (Inv_Number) REFERENCES Sale_Main (Inv_Number)
    );
GO

CREATE TABLE Payment_Mode_Master (
    Id int NOT NULL,
    Payment_Mode varchar(10) PRIMARY KEY NOT NULL,
    Status bit DEFAULT 1
    );
GO

CREATE TABLE Prefix_Master (
    Id int IDENTITY(1,1) NOT NULL,
    Prefix varchar(2) PRIMARY KEY NOT NULL,
    Acc_Type varchar(20)
    );
GO

CREATE TABLE Purchase_Body (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15),
    Item_Id int,
    IGST float,
    IGST_Amt decimal(18,2),
    C_GST float,
    C_GST_Amt decimal(18,2),
    S_GST float,
    S_GST_Amt decimal(18,2),
    Quantity int,
    Rate decimal(18,2),
    Discount float,
    Total decimal(18,2),
    FOREIGN KEY (Item_Id) REFERENCES Item_Master(Item_Id)
    );
GO

CREATE TABLE Purchase_GST_Details (
    Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15),
    Inv_Date datetime,
    GST float,
    GST_Amt decimal(18,2),
    C_GST float,
    C_GST_Amt decimal(18,2),
    S_GST float,
    S_GST_Amt  decimal(18,2),
    IGST float,
    IGST_Amt  decimal(18,2)
    );
GO

CREATE TABLE Purchase_Main (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15) NOT NULL,
    Inv_Date datetime,
    Party_Inv_Number char(20) NOT NULL,
    Party_Inv_Date datetime,
    Acc_Id int,
    Acc_Mobile_Number char(11),
    Total_GST decimal(18,2),
    Taxable_Amt decimal(18,2),
    Round_Off decimal(18,2),
    Inv_Amt decimal(18,2),
    User_Name varchar(10)
    );
GO

CREATE TABLE Sale_Body (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15),
    Item_Id int,
    IGST float,
    IGST_Amt decimal(18,2),
    C_GST float,
    C_GST_Amt decimal(18,2),
    S_GST float,
    S_GST_Amt decimal(18,2),
    Quantity int,
    Rate decimal(18,2),
    Total decimal(18,2),
    Salesman_Code varchar(10),
    FOREIGN KEY (Inv_Number) REFERENCES Sale_Main(Inv_Number)
    );
GO

CREATE TABLE Sale_GST_Details (
    Id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15),
    Inv_Date datetime,
    GST float,
    GST_Amt decimal(18,2),
    C_GST float,
    C_GST_Amt decimal(18,2),
    S_GST float,
    S_GST_Amt  decimal(18,2),
    IGST float,
    IGST_Amt  decimal(18,2)
    );
GO

CREATE TABLE Sale_Invoice_Log (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15) NOT NULL,
    Print_Date datetime,
    Printed_By varchar(50)
    );
GO

CREATE TABLE Sale_Main (
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Inv_Number char(15) NOT NULL,
    Inv_Date datetime,
    Acc_Name varchar(50) NOT NULL,
    Acc_Mobile_Number varchar(11),
    Total_GST decimal(18,2),
    Taxable_Amt decimal(18,2),
    Disc_Per float,
    Disc_Amt decimal(18,2),
    Disc_Ref char(50),
    Inv_Amt decimal(18,2),
    User_Name varchar(10)
    );
GO

CREATE TABLE Salesman_Master(
    Sl_Number int IDENTITY(1,1) NOT NULL,
    Salesman_Code varchar(10) PRIMARY KEY,
    Salesman_Name varchar(100),
    IsActive bit DEFAULT 1 NOT NULL
    );
GO

CREATE TABLE Size_Master(
    Size_id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Size_From varchar(10),
    Size_Upto varchar(10),
    S1 varchar(10),
    S2 varchar(10),
    S3 varchar(10),
    S4 varchar(10),
    S5 varchar(10),
    S6 varchar(10),
    S7 varchar(10),
    S8 varchar(10),
    S9 varchar(10),
    S10 varchar(10),
    S11 varchar(10),
    S12 varchar(10),
    S13 varchar(10),
    );
GO

CREATE TABLE State_Code_Master(
    Id int IDENTITY(1,1) NOT NULL,
    State_Code varchar(10) PRIMARY KEY NOT NULL,
    State_Name varchar(100) NOT NULL
    );
GO

CREATE TABLE Terms_Condition(
    Sl_Number int PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Terms varchar(MAX),
    Status bit DEFAULT 1
    );
GO