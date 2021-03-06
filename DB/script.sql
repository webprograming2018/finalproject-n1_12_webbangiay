USE [master]
GO
/****** Object:  Database [WEB]    Script Date: 12/30/2018 2:42:59 AM ******/
CREATE DATABASE [WEB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WEB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\WEB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'WEB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\WEB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [WEB] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [WEB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [WEB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [WEB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [WEB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [WEB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [WEB] SET ARITHABORT OFF 
GO
ALTER DATABASE [WEB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [WEB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [WEB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [WEB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [WEB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [WEB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [WEB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [WEB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [WEB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [WEB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [WEB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [WEB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [WEB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [WEB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [WEB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [WEB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [WEB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [WEB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [WEB] SET  MULTI_USER 
GO
ALTER DATABASE [WEB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [WEB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [WEB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [WEB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [WEB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [WEB] SET QUERY_STORE = OFF
GO
USE [WEB]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [WEB]
GO
/****** Object:  Table [dbo].[BillLocationShip]    Script Date: 12/30/2018 2:42:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillLocationShip](
	[IdBLS] [bigint] IDENTITY(1,1) NOT NULL,
	[IdShip] [bigint] NULL,
	[IdPX] [bigint] NULL,
	[LastLat] [real] NULL,
	[LastLng] [real] NULL,
	[Lat] [real] NULL,
	[Lng] [real] NULL,
	[updateTime] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdBLS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuXuat]    Script Date: 12/30/2018 2:43:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuXuat](
	[IdCTPX] [bigint] IDENTITY(1,1) NOT NULL,
	[IdPX] [bigint] NOT NULL,
	[IdSP] [int] NOT NULL,
	[DonGiaXuat] [money] NOT NULL,
	[SoLuongXuat] [int] NOT NULL,
	[IdMaU] [int] NOT NULL,
	[IdSize] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCTPX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 12/30/2018 2:43:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[IdDM] [int] NOT NULL,
	[TenDM] [nvarchar](100) NOT NULL,
	[TrangThai] [bit] NULL,
	[NgayTao] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/30/2018 2:43:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[idKH] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[NgayTao] [datetime] NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 12/30/2018 2:43:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[IdMau] [int] NOT NULL,
	[TenMauSac] [nvarchar](50) NOT NULL,
	[TrangThai] [bit] NULL,
	[NgayTao] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMau] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/30/2018 2:43:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[IdNCC] [int] NOT NULL,
	[TenNCC] [nvarchar](100) NOT NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Email] [varchar](50) NULL,
	[SDT] [varchar](20) NULL,
	[TrangThai] [bit] NULL,
	[NgayTao] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuXuat]    Script Date: 12/30/2018 2:43:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuXuat](
	[IdPX] [bigint] NOT NULL,
	[IdKH] [int] NULL,
	[ThanhTien] [money] NULL,
	[PTTT] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[NgayTao] [datetime] NULL,
	[TrangThai] [int] NULL,
	[IdShip] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuanLy]    Script Date: 12/30/2018 2:43:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuanLy](
	[idQL] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[TenQL] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idQL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/30/2018 2:43:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[IdSP] [int] NOT NULL,
	[IdNCC] [int] NULL,
	[IdDM] [int] NULL,
	[TenSP] [nvarchar](100) NOT NULL,
	[NgayTao] [datetime] NULL,
	[TrangThai] [bit] NULL,
	[DonGia] [money] NULL,
	[SPimage] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shipper]    Script Date: 12/30/2018 2:43:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shipper](
	[IdShip] [bigint] NOT NULL,
	[TenShip] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdShip] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 12/30/2018 2:43:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[IdSize] [int] NOT NULL,
	[TenSize] [int] NULL,
	[TrangThai] [bit] NULL,
	[NgayTao] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSize] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[BillLocationShip] ON 

INSERT [dbo].[BillLocationShip] ([IdBLS], [IdShip], [IdPX], [LastLat], [LastLng], [Lat], [Lng], [updateTime]) VALUES (1, 1, 154411416, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[BillLocationShip] ([IdBLS], [IdShip], [IdPX], [LastLat], [LastLng], [Lat], [Lng], [updateTime]) VALUES (2, 1, 154515409, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[BillLocationShip] ([IdBLS], [IdShip], [IdPX], [LastLat], [LastLng], [Lat], [Lng], [updateTime]) VALUES (3, 1, 154515409, 21.27584, 106.200279, 21.18541, 106.075027, CAST(N'2018-12-25T01:42:24.513' AS DateTime))
INSERT [dbo].[BillLocationShip] ([IdBLS], [IdShip], [IdPX], [LastLat], [LastLng], [Lat], [Lng], [updateTime]) VALUES (4, 1, 154411416, 21.0393734, 105.820457, 20.9959812, 105.809723, CAST(N'2018-12-25T01:42:24.513' AS DateTime))
INSERT [dbo].[BillLocationShip] ([IdBLS], [IdShip], [IdPX], [LastLat], [LastLng], [Lat], [Lng], [updateTime]) VALUES (5, 2, 154610021, 21.02157, 105.850281, 21.00383, 105.820747, CAST(N'2018-12-29T01:42:24.513' AS DateTime))
INSERT [dbo].[BillLocationShip] ([IdBLS], [IdShip], [IdPX], [LastLat], [LastLng], [Lat], [Lng], [updateTime]) VALUES (6, 2, 154590928, 20.99409, 105.808342, 20.9904785, 105.80217, CAST(N'2018-12-28T01:42:24.513' AS DateTime))
SET IDENTITY_INSERT [dbo].[BillLocationShip] OFF
SET IDENTITY_INSERT [dbo].[CTPhieuXuat] ON 

INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (3, 154411416, 1, 20.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (4, 154429012, 1, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (5, 154515409, 6, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (6, 154520263, 6, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (7, 154522455, 6, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (8, 154522636, 7, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (9, 154522649, 7, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (10, 154522669, 11, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (11, 154591058, 9, 2000000.0000, 2, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (12, 154594426, 2, 2000000.0000, 1, 1, 3)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (16, 154594678, 2, 2000000.0000, 1, 1, 3)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (19, 154594927, 1, 2000000.0000, 1, 1, 4)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (20, 154599184, 6, 2000000.0000, 3, 1, 3)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (21, 154609981, 2, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (22, 154610000, 6, 2000000.0000, 2, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (23, 154610021, 1, 2000000.0000, 1, 1, 3)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (24, 154610021, 11, 2000000.0000, 1, 1, 1)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (25, 154610057, 11, 2000000.0000, 1, 1, 4)
INSERT [dbo].[CTPhieuXuat] ([IdCTPX], [IdPX], [IdSP], [DonGiaXuat], [SoLuongXuat], [IdMaU], [IdSize]) VALUES (26, 154610110, 4, 2000000.0000, 1, 1, 4)
SET IDENTITY_INSERT [dbo].[CTPhieuXuat] OFF
INSERT [dbo].[DanhMuc] ([IdDM], [TenDM], [TrangThai], [NgayTao]) VALUES (1, N'Men', 1, NULL)
INSERT [dbo].[DanhMuc] ([IdDM], [TenDM], [TrangThai], [NgayTao]) VALUES (2, N'Women', 1, NULL)
INSERT [dbo].[DanhMuc] ([IdDM], [TenDM], [TrangThai], [NgayTao]) VALUES (3, N'Kids', 1, NULL)
INSERT [dbo].[DanhMuc] ([IdDM], [TenDM], [TrangThai], [NgayTao]) VALUES (5, N'c', 1, CAST(N'2018-12-06T16:49:55.197' AS DateTime))
INSERT [dbo].[DanhMuc] ([IdDM], [TenDM], [TrangThai], [NgayTao]) VALUES (154417771, N'thuy', 1, CAST(N'2018-12-07T17:15:18.953' AS DateTime))
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (1, N'thuthanh', N'123', N'Thu Thanh', CAST(N'2018-12-08T23:59:15.307' AS DateTime), 1)
INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (2, N'ngocmai', N'1234', N'Ngọc Mai', CAST(N'2018-12-09T00:17:54.857' AS DateTime), 1)
INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (8, N'thu', N'1234', N'N''Thúy TT''', CAST(N'2018-12-29T22:52:59.950' AS DateTime), 1)
INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (12, N'thuy', N'1234', N'Thúy TT', CAST(N'2018-12-29T22:56:29.357' AS DateTime), 1)
INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (13, N'thuytt', N'1234', N'Thúy TT', CAST(N'2018-12-29T23:07:27.870' AS DateTime), 1)
INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (14, N'manhnv', N'xyz', N'Mạnh Nguyễn', CAST(N'2018-12-29T23:19:45.820' AS DateTime), 1)
INSERT [dbo].[KhachHang] ([idKH], [username], [password], [TenKH], [NgayTao], [TrangThai]) VALUES (15, N'huy', N'567', N'Huy Nguyen', CAST(N'2018-12-29T23:30:02.100' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (1, N'WHITE', 1, NULL)
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (2, N'BLACK', 1, NULL)
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (3, N'BLUE', 1, NULL)
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (4, N'GREEN', 1, NULL)
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (5, N'PINK', 1, NULL)
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (6, N'RED', 1, NULL)
INSERT [dbo].[MauSac] ([IdMau], [TenMauSac], [TrangThai], [NgayTao]) VALUES (7, N'GREY', 1, NULL)
INSERT [dbo].[NhaCungCap] ([IdNCC], [TenNCC], [DiaChi], [Email], [SDT], [TrangThai], [NgayTao]) VALUES (1, N'Adidas VIETNAM', N'Việt Nam', N'adidasvn@gmail.com', N'098374637', 1, NULL)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154411416, 1, 2000000.0000, N'Live', N'dsds', CAST(N'2018-12-09T00:18:18.020' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154429012, 2, 2000000.0000, N'Live', N'ha noi', CAST(N'2018-12-09T00:28:42.783' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154515409, 2, 2000000.0000, N'Live', N'bac giang', CAST(N'2018-12-19T00:28:17.697' AS DateTime), 2, 2)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154520263, 2, 2000000.0000, NULL, NULL, CAST(N'2018-12-19T13:57:12.433' AS DateTime), 3, 2)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154522455, 2, 2000000.0000, NULL, NULL, CAST(N'2018-12-19T20:02:30.480' AS DateTime), 3, 2)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154522636, 2, 2000000.0000, NULL, NULL, CAST(N'2018-12-19T20:32:46.967' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154522649, 2, 2000000.0000, NULL, NULL, CAST(N'2018-12-19T20:34:52.720' AS DateTime), 3, 2)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154522669, 2, 2000000.0000, N'Live', N'ha noi', CAST(N'2018-12-19T20:38:14.920' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154590928, 2, 2000000.0000, N'Live', N'235 Nguyễn Trãi', CAST(N'2018-12-27T18:31:13.703' AS DateTime), 2, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154591058, 2, 4000000.0000, N'Live', N'235 NguyÃ¡Â»Ân TrÃÂ£i', CAST(N'2018-12-27T18:36:21.593' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594426, 2, 2000000.0000, N'COD', N'ha noi', CAST(N'2018-12-28T03:57:40.837' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594584, 2, 2000000.0000, N'COD', N'bac giang', CAST(N'2018-12-28T04:24:07.103' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594586, 2, 2000000.0000, N'COD', N'bac giang', CAST(N'2018-12-28T04:24:28.977' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594636, 2, 2000000.0000, N'COD', N'ha noi', CAST(N'2018-12-28T04:32:48.350' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594678, 2, 2000000.0000, N'COD', N'bac giang', CAST(N'2018-12-28T04:39:48.213' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594871, 2, 2000000.0000, N'COD', N'235 Nguyá»n TrÃ£i', CAST(N'2018-12-28T05:11:53.653' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594873, 2, 2000000.0000, N'COD', N'235 Nguyá»n TrÃ£i', CAST(N'2018-12-28T05:12:12.227' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154594927, 2, 2000000.0000, N'COD', N'235 Nguyá»n TrÃ£i', CAST(N'2018-12-28T05:21:12.923' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154599184, 2, 6000000.0000, N'COD', N'235 Nguyá»n TrÃ£i', CAST(N'2018-12-28T17:10:49.817' AS DateTime), 3, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154609981, 2, 2000000.0000, N'COD', N'235 Nguyễn Trãi', CAST(N'2018-12-29T23:10:16.180' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154610000, 12, 4000000.0000, N'COD', N'230 Nguyễn Trãi', CAST(N'2018-12-29T23:13:25.940' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154610021, 8, 4000000.0000, N'COD', N'12 Bà Triệu', CAST(N'2018-12-29T23:16:52.833' AS DateTime), 2, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154610057, 14, 2000000.0000, N'COD', N'123 Phùng Khoang', CAST(N'2018-12-29T23:22:56.570' AS DateTime), 1, 1)
INSERT [dbo].[PhieuXuat] ([IdPX], [IdKH], [ThanhTien], [PTTT], [DiaChi], [NgayTao], [TrangThai], [IdShip]) VALUES (154610110, 15, 2000000.0000, N'COD', N'25 Nguyễn Trãi', CAST(N'2018-12-29T23:31:41.610' AS DateTime), 1, 1)
SET IDENTITY_INSERT [dbo].[QuanLy] ON 

INSERT [dbo].[QuanLy] ([idQL], [username], [password], [TenQL]) VALUES (1, N'admin', N'admin', N'thuy')
SET IDENTITY_INSERT [dbo].[QuanLy] OFF
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (1, 1, 1, N'Ultra Boost 3.0', NULL, 1, 2000000.0000, N'images/pic.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (2, 1, 2, N'Adidas Neo', NULL, 1, 2000000.0000, N'images/pic1.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (3, 1, 1, N'Adidas Superstar', NULL, 1, 2000000.0000, N'images/pic2.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (4, 1, 1, N'Stan Smith', NULL, 1, 2000000.0000, N'images/pic3.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (5, 1, 1, N'Yeezy Boost 350 v2', NULL, 1, 2000000.0000, N'images/pic4.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (6, 1, 2, N'Adidas slipon', NULL, 1, 2000000.0000, N'images/pic5.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (7, 1, 2, N'Adidas NMD – NOMAD', NULL, 1, 2000000.0000, N'images/pic6.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (8, 1, 2, N'Adidas Ultra BOOST ', NULL, 1, 2000000.0000, N'images/pic7.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (9, 1, 2, N'Adidas SuperStar', NULL, 1, 2000000.0000, N'images/pic8.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (10, 1, 3, N'Kids Superstar Sneaker', NULL, 1, 2000000.0000, N'images/pic9.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (11, 1, 3, N'Performance Kids Duramo Slide', NULL, 1, 2000000.0000, N'images/pic10.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (12, 1, 3, N'Adidas Neo', NULL, 1, 2000000.0000, N'images/pic11.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (13, 1, 3, N'Stan Smith', NULL, 1, 2000000.0000, N'images/pic.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (14, 1, 3, N'Adidas NMD – NOMAD', NULL, 1, 2000000.0000, N'images/pic1.jpg')
INSERT [dbo].[SanPham] ([IdSP], [IdNCC], [IdDM], [TenSP], [NgayTao], [TrangThai], [DonGia], [SPimage]) VALUES (154533717, NULL, 5, N'tguy', NULL, NULL, 1.0000, N'images/C:UsersThuy TranDownloads3.png')
INSERT [dbo].[Shipper] ([IdShip], [TenShip]) VALUES (1, N'MINH DUNG')
INSERT [dbo].[Shipper] ([IdShip], [TenShip]) VALUES (2, N'NGOC THANH')
INSERT [dbo].[Size] ([IdSize], [TenSize], [TrangThai], [NgayTao]) VALUES (1, 6, 1, NULL)
INSERT [dbo].[Size] ([IdSize], [TenSize], [TrangThai], [NgayTao]) VALUES (2, 7, 1, NULL)
INSERT [dbo].[Size] ([IdSize], [TenSize], [TrangThai], [NgayTao]) VALUES (3, 8, 1, NULL)
INSERT [dbo].[Size] ([IdSize], [TenSize], [TrangThai], [NgayTao]) VALUES (4, 9, 1, NULL)
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__DanhMuc__4CF965593B66CE84]    Script Date: 12/30/2018 2:43:02 AM ******/
ALTER TABLE [dbo].[DanhMuc] ADD UNIQUE NONCLUSTERED 
(
	[TenDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhachHan__F3DBC572B2E4AC73]    Script Date: 12/30/2018 2:43:02 AM ******/
ALTER TABLE [dbo].[KhachHang] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__QuanLy__F3DBC5724988DCC4]    Script Date: 12/30/2018 2:43:02 AM ******/
ALTER TABLE [dbo].[QuanLy] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BillLocationShip]  WITH CHECK ADD FOREIGN KEY([IdShip])
REFERENCES [dbo].[Shipper] ([IdShip])
GO
ALTER TABLE [dbo].[BillLocationShip]  WITH CHECK ADD FOREIGN KEY([IdPX])
REFERENCES [dbo].[PhieuXuat] ([IdPX])
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD FOREIGN KEY([IdMaU])
REFERENCES [dbo].[MauSac] ([IdMau])
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD FOREIGN KEY([IdSize])
REFERENCES [dbo].[Size] ([IdSize])
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD FOREIGN KEY([IdPX])
REFERENCES [dbo].[PhieuXuat] ([IdPX])
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD FOREIGN KEY([IdSP])
REFERENCES [dbo].[SanPham] ([IdSP])
GO
ALTER TABLE [dbo].[PhieuXuat]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([idKH])
GO
ALTER TABLE [dbo].[PhieuXuat]  WITH CHECK ADD  CONSTRAINT [FK_SHIPPER_BILL] FOREIGN KEY([IdShip])
REFERENCES [dbo].[Shipper] ([IdShip])
GO
ALTER TABLE [dbo].[PhieuXuat] CHECK CONSTRAINT [FK_SHIPPER_BILL]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IdDM])
REFERENCES [dbo].[DanhMuc] ([IdDM])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IdNCC])
REFERENCES [dbo].[NhaCungCap] ([IdNCC])
GO
USE [master]
GO
ALTER DATABASE [WEB] SET  READ_WRITE 
GO
