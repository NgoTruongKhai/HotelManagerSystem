-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2021 at 07:54 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quan_li_khach_san_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_hoa_don`
--

CREATE TABLE `chi_tiet_hoa_don` (
  `id` int(11) NOT NULL,
  `thanh_tien` double NOT NULL,
  `tien_khuyen_mai` int(11) NOT NULL,
  `tien_dich_vu` double NOT NULL,
  `tien_phong` double NOT NULL,
  `ma_phong` varchar(50) NOT NULL,
  `tong_ngay_o` int(11) NOT NULL,
  `ma_dich_vu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chi_tiet_hoa_don`
--

INSERT INTO `chi_tiet_hoa_don` (`id`, `thanh_tien`, `tien_khuyen_mai`, `tien_dich_vu`, `tien_phong`, `ma_phong`, `tong_ngay_o`, `ma_dich_vu`) VALUES
(1, 1300000, 10, 1000000, 300000, 'A306', 1, 'DV1'),
(2, 1300000, 0, 1000000, 300000, 'A206', 1, 'DV1');

-- --------------------------------------------------------

--
-- Table structure for table `dich_vu`
--

CREATE TABLE `dich_vu` (
  `ma_dv` varchar(50) NOT NULL,
  `ten_dv` varchar(50) NOT NULL,
  `gia_dv` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dich_vu`
--

INSERT INTO `dich_vu` (`ma_dv`, `ten_dv`, `gia_dv`) VALUES
('DV1', 'Dịch vụ Spa', 1000000),
('DV2', 'Dịch vụ giặt, ủi là', 200000),
('DV3', 'Dịch vụ phòng 24/24', 500000),
('DV4', 'Dịch vụ xe đưa đón sân bay', 200000),
('DV5', 'Dịch vụ hội họp, văn phòng', 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `id` int(10) UNSIGNED NOT NULL,
  `ma_khach_hang` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngay_lap_hoa_don` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_khuyen_mai` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tong_tien` double NOT NULL,
  `tien_thuc` double NOT NULL,
  `tien_khuyen_mai` int(11) NOT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`id`, `ma_khach_hang`, `ma_nhan_vien`, `ngay_lap_hoa_don`, `ma_khuyen_mai`, `tong_tien`, `tien_thuc`, `tien_khuyen_mai`, `trang_thai`) VALUES
(1, '2018112345', '200002', '17-05-2021', 'DV1', 1300000, 1170000, 10, 1),
(2, '202011213', '200002', '18-05-2021', '', 1300000, 1300000, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_kh` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `gioitinh` varchar(10) NOT NULL,
  `sodienthoai` varchar(20) NOT NULL,
  `ngaysinh` varchar(20) NOT NULL,
  `diachi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_kh`, `ho`, `ten`, `gioitinh`, `sodienthoai`, `ngaysinh`, `diachi`) VALUES
('123456', 'Nguyễn', 'ABC', 'Nam', '0923712764', '17-05-2021', 'KCM'),
('2013211326', 'Đặng', 'Hoa', 'Nữ', '0923123654', '16-05-2021', 'Ninh Bình'),
('2018112345', 'Ngô ', 'Khải', 'Nam', '012345678932', '09-03-2021', 'Đà Nẵng'),
('201911213', 'Nguyễn', 'Hụe', 'Nữ', '0923754126', '05-05-2016', '273A An Dương Vương, Quận 5,TP Hồ Chí Minh '),
('202011213', 'Nguyễn văn', 'B', 'Nam', '07662316653', '06-05-2021', '273A An Dương Vương');

-- --------------------------------------------------------

--
-- Table structure for table `khuyen_mai`
--

CREATE TABLE `khuyen_mai` (
  `ma_khuyen_mai` varchar(20) NOT NULL,
  `phan_tram_khuyen_mai` int(11) NOT NULL,
  `noi_dung` varchar(100) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khuyen_mai`
--

INSERT INTO `khuyen_mai` (`ma_khuyen_mai`, `phan_tram_khuyen_mai`, `noi_dung`, `id`) VALUES
('KM1', 10, 'Tri ân khách hàng', 1),
('KM2', 5, 'Ngày thành lập khách sạn ', 2),
('KM3', 15, 'abc', 3);

-- --------------------------------------------------------

--
-- Table structure for table `loai_phong`
--

CREATE TABLE `loai_phong` (
  `ma_loai` int(11) NOT NULL,
  `gia_loai_phong` double NOT NULL,
  `so_luong_nguoi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai_phong`
--

INSERT INTO `loai_phong` (`ma_loai`, `gia_loai_phong`, `so_luong_nguoi`) VALUES
(0, 500000, 0),
(1, 300000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` varchar(20) NOT NULL,
  `id` int(11) UNSIGNED NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `Gioi_tinh` varchar(20) NOT NULL,
  `ngaysinh` varchar(20) NOT NULL,
  `chuc_vu` varchar(20) NOT NULL,
  `sodienthoai` varchar(20) NOT NULL,
  `diachi` varchar(100) NOT NULL,
  `luong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nhan_vien`, `id`, `ho`, `ten`, `Gioi_tinh`, `ngaysinh`, `chuc_vu`, `sodienthoai`, `diachi`, `luong`) VALUES
('200001', 17, 'Ngô Trường', 'Khải', 'Nam', '16-05-2021', 'Phục vụ', '0923712712', '273A An Dương Vương, Quận 5, TP Hồ Chí Minh', 5000000),
('200002', 18, 'Nguyễn', 'Huệ', 'Nữ', '01-05-2021', 'Thu ngân', '09123654789', 'Hồ Chí Minh', 5000000);

-- --------------------------------------------------------

--
-- Table structure for table `nhap_hang`
--

CREATE TABLE `nhap_hang` (
  `id` int(11) NOT NULL,
  `Ma_hang` varchar(11) NOT NULL,
  `Ten_hang` varchar(50) NOT NULL,
  `gia_tien` int(11) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `ncc` varchar(50) NOT NULL,
  `tongtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhap_hang`
--

INSERT INTO `nhap_hang` (`id`, `Ma_hang`, `Ten_hang`, `gia_tien`, `so_luong`, `ncc`, `tongtien`) VALUES
(1, 'MH1', 'khăn giấy', 2000, 1000, 'NCC khăn giấy', 2000000),
(2, 'MH2', 'nước suối', 5000, 500, 'NCC Nước suôi VN', 2500000),
(4, 'MH3', 'Khăn tắm', 10000, 700, 'NCC khăn tắm VN', 7000000);

-- --------------------------------------------------------

--
-- Table structure for table `phieu_dang_ki`
--

CREATE TABLE `phieu_dang_ki` (
  `ma_phieu` int(10) UNSIGNED NOT NULL,
  `ma_khach_hang` varchar(50) NOT NULL,
  `ngay_nhan_phong` varchar(20) NOT NULL,
  `ngay_dat_phong` varchar(20) NOT NULL,
  `ngay_tra_phong` varchar(20) NOT NULL,
  `ma_phong` varchar(50) NOT NULL,
  `ma_nhan_vien` varchar(50) NOT NULL,
  `trang_thai` int(11) NOT NULL,
  `ma_dv` varchar(20) NOT NULL,
  `ma_km` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieu_dang_ki`
--

INSERT INTO `phieu_dang_ki` (`ma_phieu`, `ma_khach_hang`, `ngay_nhan_phong`, `ngay_dat_phong`, `ngay_tra_phong`, `ma_phong`, `ma_nhan_vien`, `trang_thai`, `ma_dv`, `ma_km`) VALUES
(101, '2013211326', '17-05-2021', '17-05-2021', '18-05-2021', 'A406', '200002', 0, 'DV1', 'KM1'),
(103, '201911213', 'null', '17-05-2021', 'null', 'A302', '200002', 0, 'DV2', ''),
(104, '321654987', 'null', '17-05-2021', 'null', 'A103', '200002', 0, 'DV1', 'KM1'),
(105, '2018112345', '17-05-2021', '17-05-2021', '17-05-2021', 'A306', '200002', 1, 'DV1', 'KM1'),
(109, '202011213', '18-05-2021', '18-05-2021', '18-05-2021', 'A206', '200002', 1, 'DV1', ''),
(110, '123456', '18-05-2021', '18-05-2021', 'null', 'A101', '200002', 0, 'DV3', 'KM2'),
(111, '2013211326', '18-05-2021', '18-05-2021', 'null', 'A205', '200002', 0, 'DV5', 'KM1');

-- --------------------------------------------------------

--
-- Table structure for table `phong`
--

CREATE TABLE `phong` (
  `ma_phong` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `loai_phong` int(11) NOT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phong`
--

INSERT INTO `phong` (`ma_phong`, `loai_phong`, `trang_thai`) VALUES
('A101', 0, 3),
('A102', 0, 1),
('A103', 1, 2),
('A104', 1, 1),
('A105', 1, 1),
('A106', 1, 1),
('A201', 0, 1),
('A202', 0, 1),
('A203', 1, 1),
('A204', 1, 1),
('A205', 1, 3),
('A206', 1, 1),
('A301', 0, 1),
('A302', 0, 2),
('A303', 1, 1),
('A304', 1, 1),
('A305', 1, 1),
('A306', 1, 1),
('A401', 0, 1),
('A402', 0, 1),
('A403', 1, 1),
('A404', 1, 1),
('A405', 1, 1),
('A406', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `tai_khoan` varchar(50) NOT NULL,
  `mat_khau` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`tai_khoan`, `mat_khau`, `level`, `id`) VALUES
('200002', 'username123', 1, 1),
('admin', 'admin123', 0, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dich_vu`
--
ALTER TABLE `dich_vu`
  ADD PRIMARY KEY (`ma_dv`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_kh`);

--
-- Indexes for table `khuyen_mai`
--
ALTER TABLE `khuyen_mai`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_khuyen_mai` (`ma_khuyen_mai`);

--
-- Indexes for table `loai_phong`
--
ALTER TABLE `loai_phong`
  ADD PRIMARY KEY (`ma_loai`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD UNIQUE KEY `ma_nhan_vien` (`ma_nhan_vien`);

--
-- Indexes for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phieu_dang_ki`
--
ALTER TABLE `phieu_dang_ki`
  ADD PRIMARY KEY (`ma_phieu`);

--
-- Indexes for table `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`ma_phong`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_nhan_vien` (`tai_khoan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khuyen_mai`
--
ALTER TABLE `khuyen_mai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieu_dang_ki`
--
ALTER TABLE `phieu_dang_ki`
  MODIFY `ma_phieu` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
