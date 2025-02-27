USE [master]
GO
/****** Object:  Database [PROJECT1]    Script Date: 6/7/2024 11:46:21 AM ******/
CREATE DATABASE [PROJECT1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PROJECT1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PROJECT1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PROJECT1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PROJECT1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PROJECT1] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PROJECT1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PROJECT1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PROJECT1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PROJECT1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PROJECT1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PROJECT1] SET ARITHABORT OFF 
GO
ALTER DATABASE [PROJECT1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PROJECT1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PROJECT1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PROJECT1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PROJECT1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PROJECT1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PROJECT1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PROJECT1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PROJECT1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PROJECT1] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PROJECT1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PROJECT1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PROJECT1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PROJECT1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PROJECT1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PROJECT1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PROJECT1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PROJECT1] SET RECOVERY FULL 
GO
ALTER DATABASE [PROJECT1] SET  MULTI_USER 
GO
ALTER DATABASE [PROJECT1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PROJECT1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PROJECT1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PROJECT1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PROJECT1] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PROJECT1] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PROJECT1', N'ON'
GO
ALTER DATABASE [PROJECT1] SET QUERY_STORE = OFF
GO
USE [PROJECT1]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenChatLieu] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDCT]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDCT](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdSPCT] [int] NULL,
	[IdHoaDon] [int] NULL,
	[Gia] [decimal](18, 2) NULL,
	[TrangThai] [nvarchar](100) NULL,
	[SoLuong] [int] NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhAnh]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhAnh](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenHinhAnh] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdKhachHang] [int] NULL,
	[IdVoucher] [int] NULL,
	[IdSanPham] [int] NULL,
	[IdNhanVien] [int] NULL,
	[SoLuong] [int] NULL,
	[TongTien] [decimal](18, 2) NULL,
	[GiamGia] [decimal](18, 2) NULL,
	[ThanhTien] [decimal](18, 2) NULL,
	[TienKhachDua] [decimal](18, 2) NULL,
	[TienTraLai] [decimal](18, 2) NULL,
	[TrangThai] [nvarchar](100) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinh] [int] NULL,
	[SDT] [varchar](100) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenMau] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](255) NULL,
	[GioiTinh] [int] NULL,
	[Email] [varchar](255) NULL,
	[SDT] [varchar](255) NULL,
	[NgaySinh] [date] NULL,
	[CCCD] [varchar](255) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[TrangThai] [int] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[VaiTro] [nvarchar](100) NULL,
	[MaNV] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenSanPham] [nvarchar](255) NULL,
	[SoLuong] [int] NULL,
	[TrangThai] [int] NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenSize] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SPCT]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SPCT](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdMauSac] [int] NULL,
	[IdSanPham] [int] NULL,
	[IdHinhAnh] [int] NULL,
	[IdThuongHieu] [int] NULL,
	[IdChatLieu] [int] NULL,
	[IdSize] [int] NULL,
	[Gia] [decimal](18, 2) NULL,
	[TrangThai] [nvarchar](100) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTK] [varchar](100) NOT NULL,
	[IdNhanVien] [int] NULL,
	[TenDangNhap] [varchar](100) NULL,
	[MatKhau] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenThuongHieu] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 6/7/2024 11:46:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenVoucher] [nvarchar](255) NULL,
	[IdNhanVien] [int] NULL,
	[SoLuong] [int] NULL,
	[GiaTriToiThieu] [decimal](18, 2) NULL,
	[GiaTriToiDa] [decimal](18, 2) NULL,
	[NgayBatDau] [datetime] NULL,
	[NgayKetThuc] [datetime] NULL,
	[TrangThai] [nvarchar](100) NULL,
	[NgayTao] [date] NULL,
	[NguoiTao] [nvarchar](100) NULL,
	[NgaySua] [date] NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[GiaTri] [decimal](18, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] ON 

INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'Vải Cotton', CAST(N'2024-01-01' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'Polyester', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'Lụa', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'Vải Lan', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'Len', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'Vải Denim', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'Da', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'Nylon', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'Rayon', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin')
INSERT [dbo].[ChatLieu] ([Id], [TenChatLieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'Spandex', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin')
SET IDENTITY_INSERT [dbo].[ChatLieu] OFF
GO
SET IDENTITY_INSERT [dbo].[HDCT] ON 

INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, 1, 1, CAST(100.00 AS Decimal(18, 2)), N'Đã thanh toán', 2, CAST(N'2024-06-01' AS Date), N'Admin', CAST(N'2024-06-01' AS Date), N'Admin')
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, 2, 2, CAST(150.00 AS Decimal(18, 2)), N'Đã thanh toán', 1, CAST(N'2024-06-02' AS Date), N'Admin', CAST(N'2024-06-02' AS Date), N'Admin')
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, 5, 5, CAST(300.00 AS Decimal(18, 2)), N'Đã hủy', 5, CAST(N'2024-06-05' AS Date), N'Admin', CAST(N'2024-06-05' AS Date), N'Admin')
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, 6, 6, CAST(350.00 AS Decimal(18, 2)), N'Đã hủy', 6, CAST(N'2024-06-06' AS Date), N'Admin', CAST(N'2024-06-06' AS Date), N'Admin')
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, 7, 7, CAST(400.00 AS Decimal(18, 2)), N'Đã thanh toán', 7, CAST(N'2024-06-07' AS Date), N'Admin', CAST(N'2024-06-07' AS Date), N'Admin')
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, 10, 10, CAST(550.00 AS Decimal(18, 2)), N'Đã thanh toán', 10, CAST(N'2024-06-10' AS Date), N'Admin', CAST(N'2024-06-10' AS Date), N'Admin')
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (14, 2, 23, CAST(200.00 AS Decimal(18, 2)), NULL, 3, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (16, 4, 26, CAST(250.00 AS Decimal(18, 2)), NULL, 2, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (17, 1, 4, CAST(200.00 AS Decimal(18, 2)), NULL, 1, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (18, 1, 21, CAST(200.00 AS Decimal(18, 2)), NULL, 2, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (19, 6, 24, CAST(350.00 AS Decimal(18, 2)), NULL, 1, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (20, 1, 27, CAST(200.00 AS Decimal(18, 2)), NULL, 12, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (21, 1, 28, CAST(200.00 AS Decimal(18, 2)), NULL, 3, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (22, 7, 29, CAST(400.00 AS Decimal(18, 2)), NULL, 1, NULL, NULL, NULL, NULL)
INSERT [dbo].[HDCT] ([Id], [IdSPCT], [IdHoaDon], [Gia], [TrangThai], [SoLuong], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (23, 4, 30, CAST(250.00 AS Decimal(18, 2)), NULL, 2, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[HDCT] OFF
GO
SET IDENTITY_INSERT [dbo].[HinhAnh] ON 

INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'HinhAnh1.jpg', CAST(N'2024-01-01' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'HinhAnh2.jpg', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'HinhAnh3.jpg', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'HinhAnh4.jpg', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'HinhAnh5.jpg', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'HinhAnh6.jpg', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'HinhAnh7.jpg', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'HinhAnh8.jpg', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'HinhAnh9.jpg', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin')
INSERT [dbo].[HinhAnh] ([Id], [TenHinhAnh], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'HinhAnh10.jpg', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin')
SET IDENTITY_INSERT [dbo].[HinhAnh] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, 1, 1, 1, 1, 2, CAST(200.00 AS Decimal(18, 2)), CAST(20.00 AS Decimal(18, 2)), CAST(180.00 AS Decimal(18, 2)), CAST(200.00 AS Decimal(18, 2)), CAST(20.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-01' AS Date), N'Admin', CAST(N'2024-06-01' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, 2, 2, 2, 2, 1, CAST(150.00 AS Decimal(18, 2)), CAST(30.00 AS Decimal(18, 2)), CAST(120.00 AS Decimal(18, 2)), CAST(150.00 AS Decimal(18, 2)), CAST(30.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-02' AS Date), N'Admin', CAST(N'2024-06-02' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, 3, 3, 3, 3, 3, CAST(3.00 AS Decimal(18, 2)), CAST(300.00 AS Decimal(18, 2)), CAST(270.00 AS Decimal(18, 2)), CAST(300.00 AS Decimal(18, 2)), CAST(30.00 AS Decimal(18, 2)), N'Đã hủy', CAST(N'2024-06-03' AS Date), N'Admin', CAST(N'2024-06-03' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, 1, 1, 4, 2, 4, CAST(200.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(200.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), N'Admin', CAST(N'2024-06-04' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, 5, 5, 5, 5, 5, CAST(5.00 AS Decimal(18, 2)), CAST(500.00 AS Decimal(18, 2)), CAST(450.00 AS Decimal(18, 2)), CAST(500.00 AS Decimal(18, 2)), CAST(50.00 AS Decimal(18, 2)), N'Đã hủy', CAST(N'2024-06-05' AS Date), N'Admin', CAST(N'2024-06-05' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, 6, 6, 6, 6, 6, CAST(6.00 AS Decimal(18, 2)), CAST(600.00 AS Decimal(18, 2)), CAST(540.00 AS Decimal(18, 2)), CAST(600.00 AS Decimal(18, 2)), CAST(60.00 AS Decimal(18, 2)), N'Đã hủy', CAST(N'2024-06-06' AS Date), N'Admin', CAST(N'2024-06-06' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, 7, 7, 7, 7, 7, CAST(2800.00 AS Decimal(18, 2)), CAST(700.00 AS Decimal(18, 2)), CAST(630.00 AS Decimal(18, 2)), CAST(700.00 AS Decimal(18, 2)), CAST(70.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), N'Admin', CAST(N'2024-06-07' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, 8, 8, 8, 8, 8, CAST(8.00 AS Decimal(18, 2)), CAST(800.00 AS Decimal(18, 2)), CAST(720.00 AS Decimal(18, 2)), CAST(800.00 AS Decimal(18, 2)), CAST(80.00 AS Decimal(18, 2)), N'Đã hủy', CAST(N'2024-06-08' AS Date), N'Admin', CAST(N'2024-06-08' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, 9, 9, 9, 9, 9, CAST(9.00 AS Decimal(18, 2)), CAST(900.00 AS Decimal(18, 2)), CAST(810.00 AS Decimal(18, 2)), CAST(900.00 AS Decimal(18, 2)), CAST(90.00 AS Decimal(18, 2)), N'Đã hủy', CAST(N'2024-06-09' AS Date), N'Admin', CAST(N'2024-06-09' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, 10, 10, 10, 10, 10, CAST(5500.00 AS Decimal(18, 2)), CAST(1000.00 AS Decimal(18, 2)), CAST(900.00 AS Decimal(18, 2)), CAST(1000.00 AS Decimal(18, 2)), CAST(100.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-10' AS Date), N'Admin', CAST(N'2024-06-10' AS Date), N'Admin')
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-05' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (21, 1, 1, NULL, 2, NULL, CAST(400.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(400.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (23, 1, 1, NULL, 2, NULL, CAST(600.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(600.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (24, 1, 1, NULL, 2, NULL, CAST(350.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(350.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Đã hủy', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (26, 1, 1, NULL, 2, NULL, CAST(500.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(500.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (27, 1, 1, NULL, 2, NULL, CAST(2400.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(2400.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (28, 1, 1, NULL, 2, NULL, CAST(600.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(600.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (29, 1, 1, NULL, 2, NULL, CAST(400.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(400.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKhachHang], [IdVoucher], [IdSanPham], [IdNhanVien], [SoLuong], [TongTien], [GiamGia], [ThanhTien], [TienKhachDua], [TienTraLai], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (30, 1, 1, NULL, 2, NULL, CAST(500.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(500.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'Đã thanh toán', CAST(N'2024-06-07' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'Nguyễn Van A', 1, N'0123456789', N'123 Ðu?ng ABC, Qu?n 1, TP.HCM', CAST(N'2024-01-01' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'Trần Thị B', 0, N'0123456788', N'456 Ðu?ng XYZ, Qu?n 2, TP.HCM', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'Lê Văn C', 1, N'0123456787', N'789 Ðu?ng LMN, Qu?n 3, TP.HCM', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'Phạm Thị D', 0, N'0123456786', N'101 Ðu?ng EFG, Qu?n 4, TP.HCM', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'Ngô Văn E', 1, N'0123456785', N'202 Ðu?ng HIJ, Qu?n 5, TP.HCM', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'Ðặng Thị F', 0, N'0123456784', N'303 Ðu?ng KLM, Qu?n 6, TP.HCM', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'Bùi Van G', 1, N'0123456783', N'404 Ðu?ng NOP, Qu?n 7, TP.HCM', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'Vũ Thị H', 0, N'0123456782', N'505 Ðu?ng QRS, Qu?n 8, TP.HCM', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'Dương Văn J', 1, N'0123456781', N'606 Ðu?ng TUV, Qu?n 9, TP.HCM', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin')
INSERT [dbo].[KhachHang] ([Id], [HoTen], [GioiTinh], [SDT], [DiaChi], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'Phan Thị J', 0, N'0123456780', N'707 Ðu?ng WXY, Qu?n 10, TP.HCM', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'Ðỏ', CAST(N'2024-01-01' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'Xanh Duong', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'Xanh Lá', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'Vàng', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'Tím', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'Cam', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'Hồng', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'Nâu', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'Ðen', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'Tr?ng', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin')
INSERT [dbo].[MauSac] ([Id], [TenMau], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (11, N'tesst6', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (1, N'Name 1', 1, N'demoupdate@gmail.com', N'0345678910', CAST(N'2004-12-12' AS Date), N'1623457890', CAST(N'2024-06-06' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin', 0, N'Hà Nội', N'', NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (2, N'Trần Văn Thái', 1, N'tranvanthai@gmail.com', N'0123456788', CAST(N'1991-02-02' AS Date), N'123456788', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin', 1, N'Đà Nẵng', N'Quản lý', N'QL001')
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (3, N'Lê Văn C', 1, N'levanc@example.com', N'0123456787', CAST(N'1992-03-03' AS Date), N'123456787', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin', 0, N'Hà Nội', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (4, N'Phạm Thị D', 0, N'phamthid@example.com', N'0123456786', CAST(N'1993-04-04' AS Date), N'123456786', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin', 1, N'Đà Lạt', N'Nhân viên', NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (5, N'Ngô Văn E', 1, N'ngovane@example.com', N'0123456785', CAST(N'1994-05-05' AS Date), N'123456785', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin', 0, N'Nam Định', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (6, N'Ðặng Thị F', 0, N'dothif@example.com', N'0123456784', CAST(N'1995-06-06' AS Date), N'123456784', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin', 1, N'Hà Nội', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (7, N'Bùi Văn Hai', 1, N'buivang@example.com', N'0123456783', CAST(N'1996-07-07' AS Date), N'123456783', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin', 0, N'Nam Định', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (8, N'Bùi Nam Khánh', 0, N'vuthih@example.com', N'0123456782', CAST(N'1997-08-08' AS Date), N'123456782', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin', 1, N'Hà Nội', N'Nhân viên', N'NV01')
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (9, N'Bùi Khánh Nam', 1, N'duongvani@example.com', N'0123456781', CAST(N'1998-09-09' AS Date), N'123456781', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin', 0, N'Đà Lạt', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (10, N'Nam Khánh Bùi', 0, N'phanthij@example.com', N'0123456780', CAST(N'1999-10-10' AS Date), N'123456780', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin', 1, N'Đà Lạt', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (11, N'name 1', 0, N'name1@gmail.com', N'0987654321', CAST(N'2004-12-12' AS Date), N'1234567890', CAST(N'2024-06-06' AS Date), NULL, NULL, NULL, 1, N'Đà Nẵng', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (12, N'name 1', 1, N'aaaa@gmail.com', N'09648392738', CAST(N'2022-12-21' AS Date), N'78748748473', CAST(N'2024-06-06' AS Date), NULL, NULL, NULL, 0, N'Đà Nẵng', NULL, NULL)
INSERT [dbo].[NhanVien] ([Id], [HoTen], [GioiTinh], [Email], [SDT], [NgaySinh], [CCCD], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [TrangThai], [DiaChi], [VaiTro], [MaNV]) VALUES (13, N'name3', 1, N'aaaa@gmail.com', N'77777111', CAST(N'2024-11-20' AS Date), N'166161661', CAST(N'2024-06-06' AS Date), NULL, NULL, NULL, 1, N'Đà Nẵng', NULL, NULL)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'Áo Sơ Mi Nam', 100, 1, CAST(N'2024-06-01' AS Date), N'Admin', CAST(N'2024-06-01' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'Áo Thun Nữ', 150, 1, CAST(N'2024-06-02' AS Date), N'Admin', CAST(N'2024-06-02' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'Quần Jeans Nam', 184, 1, CAST(N'2024-06-03' AS Date), N'Admin', CAST(N'2024-06-03' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'Áo LV Siu Cấppppp', 124, 1, CAST(N'2024-06-04' AS Date), N'Admin', CAST(N'2024-06-04' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'Áo Khoác Unisex', 80, 1, CAST(N'2024-06-05' AS Date), N'Admin', CAST(N'2024-06-05' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'Quần Legging Nữ', 179, 1, CAST(N'2024-06-06' AS Date), N'Admin', CAST(N'2024-06-06' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'Bộ Vest Nam', 89, 1, CAST(N'2024-06-07' AS Date), N'Admin', CAST(N'2024-06-07' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'Áo Dài Cách Tân', 78, 1, CAST(N'2024-06-08' AS Date), N'Admin', CAST(N'2024-06-08' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'Chân Váy Xòe', 139, 1, CAST(N'2024-06-09' AS Date), N'Admin', CAST(N'2024-06-09' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'Áo Hoodie Nỉ', 110, 1, CAST(N'2024-06-10' AS Date), N'Admin', CAST(N'2024-06-10' AS Date), N'Admin')
INSERT [dbo].[SanPham] ([Id], [TenSanPham], [SoLuong], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (11, N'ao coc', 100, 1, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[Size] ON 

INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'XS', CAST(N'2024-01-01' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'S', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'M', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'L', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'XL', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'XXL', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'XXXL', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'4XL', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'5XL', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin')
INSERT [dbo].[Size] ([Id], [TenSize], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'6XL', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin')
SET IDENTITY_INSERT [dbo].[Size] OFF
GO
SET IDENTITY_INSERT [dbo].[SPCT] ON 

INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, 3, 3, 1, 1, 4, 3, CAST(200.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-01' AS Date), N'Admin', CAST(N'2024-06-01' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, 3, 3, 2, 1, 3, 3, CAST(200.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-02' AS Date), N'Admin', CAST(N'2024-06-02' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, 3, 3, 3, 2, 3, 3, CAST(200.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-03' AS Date), N'Admin', CAST(N'2024-06-03' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, 4, 4, 4, 4, 4, 4, CAST(250.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-04' AS Date), N'Admin', CAST(N'2024-06-04' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, 5, 5, 5, 5, 5, 5, CAST(300.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-05' AS Date), N'Admin', CAST(N'2024-06-05' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, 6, 6, 6, 6, 6, 6, CAST(350.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-06' AS Date), N'Admin', CAST(N'2024-06-06' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, 7, 7, 7, 7, 7, 7, CAST(400.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-07' AS Date), N'Admin', CAST(N'2024-06-07' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, 8, 8, 8, 8, 8, 8, CAST(450.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-08' AS Date), N'Admin', CAST(N'2024-06-08' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, 9, 9, 9, 9, 9, 9, CAST(500.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-09' AS Date), N'Admin', CAST(N'2024-06-09' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, 10, 10, 10, 10, 10, 10, CAST(550.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-10' AS Date), N'Admin', CAST(N'2024-06-10' AS Date), N'Admin')
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (11, 3, 3, NULL, 4, 3, 3, CAST(200.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-04' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (12, 1, 11, NULL, 1, 1, 4, CAST(300.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-04' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SPCT] ([Id], [IdMauSac], [IdSanPham], [IdHinhAnh], [IdThuongHieu], [IdChatLieu], [IdSize], [Gia], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (13, 1, 11, NULL, 1, 1, 5, CAST(300.00 AS Decimal(18, 2)), N'Còn hàng', CAST(N'2024-06-04' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[SPCT] OFF
GO
INSERT [dbo].[TaiKhoan] ([MaTK], [IdNhanVien], [TenDangNhap], [MatKhau]) VALUES (N'TK001', 2, N'thaitv', N'1234')
INSERT [dbo].[TaiKhoan] ([MaTK], [IdNhanVien], [TenDangNhap], [MatKhau]) VALUES (N'TK002', 8, N'khanhbn', N'6781')
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 

INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (1, N'Gucci', CAST(N'2024-01-01' AS Date), N'Admin', CAST(N'2024-01-01' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (2, N'Louis Vuitton', CAST(N'2024-01-02' AS Date), N'Admin', CAST(N'2024-01-02' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (3, N'Prada', CAST(N'2024-01-03' AS Date), N'Admin', CAST(N'2024-01-03' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (4, N'Chanel', CAST(N'2024-01-04' AS Date), N'Admin', CAST(N'2024-01-04' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (5, N'Dior', CAST(N'2024-01-05' AS Date), N'Admin', CAST(N'2024-01-05' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (6, N'Versace', CAST(N'2024-01-06' AS Date), N'Admin', CAST(N'2024-01-06' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (7, N'Givenchy', CAST(N'2024-01-07' AS Date), N'Admin', CAST(N'2024-01-07' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (8, N'Balenciaga', CAST(N'2024-01-08' AS Date), N'Admin', CAST(N'2024-01-08' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (9, N'Hermès', CAST(N'2024-01-09' AS Date), N'Admin', CAST(N'2024-01-09' AS Date), N'Admin')
INSERT [dbo].[ThuongHieu] ([Id], [TenThuongHieu], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua]) VALUES (10, N'Valentino', CAST(N'2024-01-10' AS Date), N'Admin', CAST(N'2024-01-10' AS Date), N'Admin')
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
SET IDENTITY_INSERT [dbo].[Voucher] ON 

INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (1, N'Voucher 1', 1, 1000, CAST(100.00 AS Decimal(18, 2)), CAST(200.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-01' AS Date), N'Admin', CAST(N'2024-06-01' AS Date), N'Admin', CAST(150.00 AS Decimal(18, 2)))
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (2, N'Voucher 2', 2, 200, CAST(200.00 AS Decimal(18, 2)), CAST(400.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hết hạn', CAST(N'2024-06-02' AS Date), N'Admin', CAST(N'2024-06-02' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (3, N'Voucher 3', 3, 300, CAST(300.00 AS Decimal(18, 2)), CAST(600.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-03' AS Date), N'Admin', CAST(N'2024-06-03' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (4, N'Voucher 4', 4, 400, CAST(400.00 AS Decimal(18, 2)), CAST(800.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hết hạn', CAST(N'2024-06-04' AS Date), N'Admin', CAST(N'2024-06-04' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (5, N'Voucher 5', 5, 500, CAST(500.00 AS Decimal(18, 2)), CAST(1000.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-05' AS Date), N'Admin', CAST(N'2024-06-05' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (6, N'Voucher 6', 6, 600, CAST(600.00 AS Decimal(18, 2)), CAST(1200.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-06' AS Date), N'Admin', CAST(N'2024-06-06' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (7, N'Voucher 7', 7, 700, CAST(700.00 AS Decimal(18, 2)), CAST(1400.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-07' AS Date), N'Admin', CAST(N'2024-06-07' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (8, N'Voucher 8', 8, 800, CAST(800.00 AS Decimal(18, 2)), CAST(1600.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-08' AS Date), N'Admin', CAST(N'2024-06-08' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (9, N'Voucher 9', 9, 900, CAST(900.00 AS Decimal(18, 2)), CAST(1800.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hết hạn', CAST(N'2024-06-09' AS Date), N'Admin', CAST(N'2024-06-09' AS Date), N'Admin', NULL)
INSERT [dbo].[Voucher] ([Id], [TenVoucher], [IdNhanVien], [SoLuong], [GiaTriToiThieu], [GiaTriToiDa], [NgayBatDau], [NgayKetThuc], [TrangThai], [NgayTao], [NguoiTao], [NgaySua], [NguoiSua], [GiaTri]) VALUES (10, N'Voucher 10', 10, 1000, CAST(1000.00 AS Decimal(18, 2)), CAST(2000.00 AS Decimal(18, 2)), CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2024-06-30T23:59:59.000' AS DateTime), N'Hoạt động', CAST(N'2024-06-10' AS Date), N'Admin', CAST(N'2024-06-10' AS Date), N'Admin', NULL)
SET IDENTITY_INSERT [dbo].[Voucher] OFF
GO
ALTER TABLE [dbo].[HDCT]  WITH CHECK ADD  CONSTRAINT [FK_HDCT_HoaDon] FOREIGN KEY([IdHoaDon])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[HDCT] CHECK CONSTRAINT [FK_HDCT_HoaDon]
GO
ALTER TABLE [dbo].[HDCT]  WITH CHECK ADD  CONSTRAINT [FK_HDCT_SPCT] FOREIGN KEY([IdSPCT])
REFERENCES [dbo].[SPCT] ([Id])
GO
ALTER TABLE [dbo].[HDCT] CHECK CONSTRAINT [FK_HDCT_SPCT]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([IdKhachHang])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([IdNhanVien])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_SanPham] FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Voucher] FOREIGN KEY([IdVoucher])
REFERENCES [dbo].[Voucher] ([Id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Voucher]
GO
ALTER TABLE [dbo].[SPCT]  WITH CHECK ADD  CONSTRAINT [FK_SPCT_ChatLieu] FOREIGN KEY([IdChatLieu])
REFERENCES [dbo].[ChatLieu] ([Id])
GO
ALTER TABLE [dbo].[SPCT] CHECK CONSTRAINT [FK_SPCT_ChatLieu]
GO
ALTER TABLE [dbo].[SPCT]  WITH CHECK ADD  CONSTRAINT [FK_SPCT_HinhAnh] FOREIGN KEY([IdHinhAnh])
REFERENCES [dbo].[HinhAnh] ([Id])
GO
ALTER TABLE [dbo].[SPCT] CHECK CONSTRAINT [FK_SPCT_HinhAnh]
GO
ALTER TABLE [dbo].[SPCT]  WITH CHECK ADD  CONSTRAINT [FK_SPCT_MauSac] FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[SPCT] CHECK CONSTRAINT [FK_SPCT_MauSac]
GO
ALTER TABLE [dbo].[SPCT]  WITH CHECK ADD  CONSTRAINT [FK_SPCT_SanPham] FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[SPCT] CHECK CONSTRAINT [FK_SPCT_SanPham]
GO
ALTER TABLE [dbo].[SPCT]  WITH CHECK ADD  CONSTRAINT [FK_SPCT_Size] FOREIGN KEY([IdSize])
REFERENCES [dbo].[Size] ([Id])
GO
ALTER TABLE [dbo].[SPCT] CHECK CONSTRAINT [FK_SPCT_Size]
GO
ALTER TABLE [dbo].[SPCT]  WITH CHECK ADD  CONSTRAINT [FK_SPCT_ThuongHieu] FOREIGN KEY([IdThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([Id])
GO
ALTER TABLE [dbo].[SPCT] CHECK CONSTRAINT [FK_SPCT_ThuongHieu]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([IdNhanVien])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [FK_Voucher_NhanVien] FOREIGN KEY([IdNhanVien])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [FK_Voucher_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [PROJECT1] SET  READ_WRITE 
GO
