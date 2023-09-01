package com.example.pcsimulator.models;

import com.example.pcsimulator.R;
import com.example.pcsimulator.models.ShopItem;
import java.util.ArrayList;
import java.util.List;

public class ShopItemList {
    public List<ShopItem> shopItemList = new ArrayList<>();

    public ShopItemList() {

        shopItemList.add(new ShopItem(1, 1, "ASRock H310CM", "7590", R.drawable.mb1, "Form factor", "Micro-ATX", "CPU Socket", "LGA 1151", "Chipset Type", "Intel"));
        shopItemList.add(new ShopItem(2, 1, "ASRock H470M", "9990", R.drawable.mb2, "Form factor", "Micro-ATX", "CPU Socket", "LGA 1200", "Chipset Type", "Intel "));
        shopItemList.add(new ShopItem(3, 1, "Biostar A68MHE", "4590", R.drawable.mb3, "Form factor", "Micro-ATX", "CPU Socket", "FM2+", "Chipset Type", "AMD"));
        shopItemList.add(new ShopItem(4, 1, "AFOX A88", "6690", R.drawable.mb4, "Form factor", "Micro-ATX", "CPU Socket", "FM2+", "Chipset Type", "AMD"));
        shopItemList.add(new ShopItem(5, 1, "Esonic G31", "3990", R.drawable.mb5, "Form factor", "Micro-ATX", "CPU Socket", "LGA 775", "Chipset Type", "Intel "));
        shopItemList.add(new ShopItem(6, 1, "AFOX IH61-MA2-V3", "3999", R.drawable.mb6, "Form factor", "Mini-DTX", "CPU Socket", "LGA 1155", "Chipset Type", "Intel"));
        shopItemList.add(new ShopItem(7, 1, "ASRock H310CM-DVS", "3999", R.drawable.mb7, "Form factor", "Micro-ATX", "CPU Socket", "LGA 1151-v2", "Chipset Type", "Intel "));
        shopItemList.add(new ShopItem(8, 1, "ASUS PRIME Z690-A", "20999", R.drawable.mb8, "Form factor", "Standart-ATX", "CPU Socket", "LGA 1700", "Chipset Type", "Intel"));
        shopItemList.add(new ShopItem(9, 1, "ASUS ROG CROSSHAIR X670E HERO", "59999", R.drawable.mb9, "Form factor", "Standart-ATX", "CPU Socket", "AM5", "Chipset Type", "AMD"));
        shopItemList.add(new ShopItem(10, 1, "Esonic H81DA1 V5.1", "3999", R.drawable.mb5, "Form factor", "Micro-ATX", "CPU Socket", "LGA 1150", "Chipset Type", "Intel "));

        shopItemList.add(new ShopItem(11, 2, "INTEL CORE I5-11400F", "14990", R.drawable.cpu1, "CPU Socket", "LGA 1200", "Num of Processors", "6", "CPU Speed", "2.6 GHz"));
        shopItemList.add(new ShopItem(12, 2, "INTEL CORE i3-10105p", "12990", R.drawable.cpu2, "CPU Socket", "LGA 1200", "Num of Processors", "4", "CPU Speed", "3.7 GHz"));
        shopItemList.add(new ShopItem(13, 2, "AMD Ryzen 5 5600X", "9900", R.drawable.cpu3, "CPU Socket", "AM4", "Num of Processors", "6", "CPU Speed", "3.7 GHz"));
        shopItemList.add(new ShopItem(14, 2, "AMD Ryzen 7 5800X", "15990", R.drawable.cpu4, "CPU Socket", "AM4", "Num of Processors", "8", "CPU Speed", "3.8 GHz"));
        shopItemList.add(new ShopItem(15, 2, "AMD Ryzen 5 3600", "6990", R.drawable.cpu5, "CPU Socket", "AM4", "Num of Processors", "6", "CPU Speed", "3.6 GHz"));
        shopItemList.add(new ShopItem(16, 2, "AMD A6-9500 OEM", "1399", R.drawable.cpu6, "CPU Socket", "АМ4", "Num of Processors", "2", "CPU Speed", "3.5 GHz"));
        shopItemList.add(new ShopItem(17, 2, "AMD Athlon X4 970 OEM", "1999", R.drawable.cpu7, "CPU Socket", "АМ4", "Num of Processors", "4", "CPU Speed", "3.8 GHz"));
        shopItemList.add(new ShopItem(18, 2, "AMD FX-4300 BOX", "2899", R.drawable.cpu8, "CPU Socket", "АМ3+", "Num of Processors", "4", "CPU Speed", "3.8 GHz"));
        shopItemList.add(new ShopItem(19, 2, "INTEL CORE i3-10105F", "5999", R.drawable.cpu9, "CPU Socket", "LGA 1200", "Num of Processors", "4", "CPU Speed", "3.7 GHz"));
        shopItemList.add(new ShopItem(20, 2, "AMD A6-9500E OEM", "899", R.drawable.cpu10, "CPU Socket", "AM4", "Num of Processors", "2", "CPU Speed", "3 GHz"));

        shopItemList.add(new ShopItem(21, 3, "Fury Beast Black", "4490", R.drawable.ram1, "Memory Technology", "DDR4", "Memory capacity", "16 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(22, 3, "ADATA XPG GAMMIX D20", "4890", R.drawable.ram2, "Memory Technology", "DDR4", "Memory capacity", "32 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(23, 3, "ADATA XPG GAMMIX D10", "3890", R.drawable.ram3, "Memory Technology", "DDR4", "Memory capacity", "32 GB", "Memory Speed", "3600 MGz"));
        shopItemList.add(new ShopItem(24, 3, "AMD Radeon R9", "3490", R.drawable.ram4, "Memory Technology", "DDR4", "Memory capacity", "16 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(25, 3, "ADATA XPG SPECTRIX RGB", "5790", R.drawable.ram5, "Memory Technology", "DDR4", "Memory capacity", "32 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(26, 3, "AMD Radeon R5 Entertainment Series", "1299", R.drawable.ram6, "Memory Technology", "DDR3", "Memory capacity", "8 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(27, 3, "Apacer", "1499", R.drawable.ram7, "Memory Technology", "DDR3", "Memory capacity", "8 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(28, 3, "G.Skill RIPJAWS V", "3699", R.drawable.ram8, "Memory Technology", "DDR4", "Memory capacity", "8 GB", "Memory Speed", "3600 MGz"));
        shopItemList.add(new ShopItem(29, 3, "Kingston FURY Renegade Silver RGB", "18499", R.drawable.ram9, "Memory Technology", "DDR5", "Memory capacity", "32 GB", "Memory Speed", "3200 MGz"));
        shopItemList.add(new ShopItem(30, 3, "Patriot Signature", "1699", R.drawable.ram10, "Memory Technology", "DDR3", "Memory capacity", "8 GB", "Memory Speed", "3200 MGz"));

        shopItemList.add(new ShopItem(31, 4, "RTX 3070 TI", "59990", R.drawable.vc1, "Chipset Brand", "NVIDIA","Graphics Ram Size", "8 GB", "GPU Clock Speed", "1575 MGz"));
        shopItemList.add(new ShopItem(32, 4, "RTX 4090 GAMING", "151990", R.drawable.vc2, "Chipset Brand", "NVIDIA","Graphics Ram Size", "24 GB", "GPU Clock Speed", "2235 MGz"));
        shopItemList.add(new ShopItem(33, 4, "RTX 3060 Dual", "32990", R.drawable.vc3, "Chipset Brand", "NVIDIA","Graphics Ram Size", "12 GB", "GPU Clock Speed", "1320 MGz"));
        shopItemList.add(new ShopItem(34, 4, "RTX 4070 TI", "89990", R.drawable.vc4, "Chipset Brand", "NVIDIA","Graphics Ram Size", "12 GB", "GPU Clock Speed", "2310 MGz"));
        shopItemList.add(new ShopItem(35, 4, "RTX 3070", "51990", R.drawable.vc5, "Chipset Brand", "NVIDIA","Graphics Ram Size", "8 GB", "GPU Clock Speed", "1500 MGz"));
        shopItemList.add(new ShopItem(36, 4, "MSI GeForce GT 730", "5199", R.drawable.vc6, "Chipset Brand", "NVIDIA","Graphics Ram Size", "2 GB", "GPU Clock Speed", "700 MGz"));
        shopItemList.add(new ShopItem(37, 4, "MSI GeForce GTX 1650", "14999", R.drawable.vc7, "Chipset Brand", "NVIDIA","Graphics Ram Size", "4 GB", "GPU Clock Speed", "1485 MGz"));
        shopItemList.add(new ShopItem(38, 4, "Palit GeForce GTX 1630 Dual", "13499", R.drawable.vc8, "Chipset Brand", "NVIDIA","Graphics Ram Size", "4 GB", "GPU Clock Speed", "1740 MGz"));
        shopItemList.add(new ShopItem(39, 4, "Sapphire AMD Radeon RX 550 PULSE", "8999", R.drawable.vc9, "Chipset Brand", "NVIDIA","Graphics Ram Size", "4 GB", "GPU Clock Speed", "1100 MGz"));
        shopItemList.add(new ShopItem(40, 4, "Sapphire PULSE AMD Radeon RX 6400", "11999", R.drawable.vc10, "Chipset Brand", "NVIDIA","Graphics Ram Size", "4 GB", "GPU Clock Speed", "1923 MGz"));

        shopItemList.add(new ShopItem(41, 5, "ExeGate AA500", "1990", R.drawable.bp1, "Connector Type", "EPS", "Wattage", "500 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(42, 5, "ExeGate AB400", "2490", R.drawable.bp2, "Connector Type", "EPS", "Wattage", "400 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(43, 5, "Corsair HX1000", "4500", R.drawable.bp3, "Connector Type", "EPS", "Wattage", "1000 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(44, 5, "DEEPCOOL PQ850M", "6500", R.drawable.bp4, "Connector Type", "EPS", "Wattage", "850 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(45, 5, "DEEPCOOL DQ750", "7990", R.drawable.bp5, "Connector Type", "EPS", "Wattage", "750 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(46, 5, "AeroCool VX PLUS 500W", "2450", R.drawable.bp6, "Connector Type", "VX PLUS", "Wattage", "500 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(47, 5, "AeroCool VX PLUS 600W", "2799", R.drawable.bp7, "Connector Type", "VX PLUS", "Wattage", "600 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(48, 5, "DEEPCOOL PF600", "3999", R.drawable.bp8, "Connector Type", "PF600", "Wattage", "600 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(49, 5, "Xilence Red Wings XN054 700W", "3099", R.drawable.bp9, "Connector Type", "Red Wings XN054 ", "Wattage", "700 watts", "Form factor", "ATX"));
        shopItemList.add(new ShopItem(50, 5, "ZALMAN ZM600-LXII", "3699", R.drawable.bp10, "Connector Type", "ZM600-LXII", "Wattage", "600 watts", "Form factor", "ATX"));

        shopItemList.add(new ShopItem(51, 6, "ZALMAN I3 Edge", "2490", R.drawable.case1, "Case Type", "Mid Tower", "Color", "Black", "Material", "Steel, plastic"));
        shopItemList.add(new ShopItem(52, 6, "ZET Gaming Rare M2", "3590", R.drawable.case2, "Case Type", "Mid Tower", "Color", "Black", "Material", "Steel, glass"));
        shopItemList.add(new ShopItem(53, 6, "Cougar MX330-F", "4390", R.drawable.case3, "Case Type", "Mid Tower", "Color", "Black", "Material", "Steel, plastic"));
        shopItemList.add(new ShopItem(54, 6, "DEEPCOOL CK560", "5549", R.drawable.case4, "Case Type", "Mid Tower", "Color", "Black", "Material", "Steel, glass"));
        shopItemList.add(new ShopItem(55, 6, "Cougar MX330-G", "2990", R.drawable.case5, "Case Type", "Mid Tower", "Color", "Black", "Material", "Glass, steel"));
        shopItemList.add(new ShopItem(56, 6, "AeroCool Cylon", "3999", R.drawable.case6, "Case Type", "Mid Tower", "Color", "White", "Material", "Steel, plastic"));
        shopItemList.add(new ShopItem(57, 6, "DEEPCOOL Wave V2", "2799", R.drawable.case7, "Case Type", "Mini-Tower", "Color", "Black", "Material", "Steel"));
        shopItemList.add(new ShopItem(58, 6, "DEXP DC-201M", "2499", R.drawable.case8, "Case Type", "Mini-Tower", "Color", "Black", "Material", "Steel, glass"));
        shopItemList.add(new ShopItem(59, 6, "Lian Li LANCOOL III RGB", "13499", R.drawable.case9, "Case Type", "Mid Tower", "Color", "White", "Material", "Steel, glass"));
        shopItemList.add(new ShopItem(60, 6, "ZET GAMING Rare Minicase MS2 BG", "3799", R.drawable.case10, "Case Type", "Mini-Tower", "Color", "White", "Material", "Glass, steel"));

        shopItemList.add(new ShopItem(61, 7, "Seagate Barra Cuda 1TB", "4590", R.drawable.hdd1, "Capacity", "1 TB", "RPM", "7200", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(62, 7, "WD Purple Surveillance", "8990", R.drawable.hdd2, "Capacity", "8 TB", "RPM", "5640", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(63, 7, "Seagate Barra Cuda 2TB", "6990", R.drawable.hdd3, "Capacity", "2 TB", "RPM", "7200", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(64, 7, "WD Purple Surveillance 4TB", "5990", R.drawable.hdd4, "Capacity", "4 TB", "RPM", "5400", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(65, 7, "Seagate SkyHawk 6TB", "8990", R.drawable.hdd5, "Capacity", "6 TB", "RPM", "5400", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(66, 7, "Seagate SkyHawk", "3999", R.drawable.hdd6, "Capacity", "1 TB", "RPM", "7200", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(67, 7, "Seagate Surveillance", "3499", R.drawable.hdd7, "Capacity", "2 TB", "RPM", "5640", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(68, 7, "Toshiba DT01", "4199", R.drawable.hdd8, "Capacity", "2 TB", "RPM", "7200", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(69, 7, "WB Blue", "3499", R.drawable.hdd9, "Capacity", "1 TB", "RPM", "5400", "Interface", "6.0Gb/s"));
        shopItemList.add(new ShopItem(90, 7, "WD Purple", "3699", R.drawable.hdd10, "Capacity", "1 TB", "RPM", "5400", "Interface", "6.0Gb/s"));

        shopItemList.add(new ShopItem(91, 8, "Samsung 870", "3690", R.drawable.ssd1, "Capacity", "500 GB", "Max Sequential Write", "560 MBps", "Max Sequential Read","530 MBps"));
        shopItemList.add(new ShopItem(92, 8, "Apacer AS350 Panther", "4690",R.drawable.ssd2, "Capacity", "256 GB", "Max Sequential Write", "560 MBps", "Max Sequential Read","540 MBps"));
        shopItemList.add(new ShopItem(93, 8, "Crucial BX500", "5390", R.drawable.ssd3, "Capacity", "480 GB", "Max Sequential Write", "540 MBps", "Max Sequential Read","500 MBps"));
        shopItemList.add(new ShopItem(94, 8, "ADATA SU800", "6690", R.drawable.ssd4, "Capacity", "512 GB", "Max Sequential Write", "560 MBps", "Max Sequential Read","520 MBps"));
        shopItemList.add(new ShopItem(95, 8, "Patriot Memory P210", "3290", R.drawable.ssd5, "Capacity", "512 GB", "Max Sequential Write", "520 MBps", "Max Sequential Read","430 MBps"));
        shopItemList.add(new ShopItem(96, 8, "ADATA SU650", "1699", R.drawable.ssd6, "Capacity", "240 GB", "Max Sequential Write", "520 MBps", "Max Sequential Read","450 MBps"));
        shopItemList.add(new ShopItem(97, 8, "Kingston A400", "2799",R.drawable.ssd7, "Capacity", "480 GB", "Max Sequential Write", "500 MBps", "Max Sequential Read","450 MBps"));
        shopItemList.add(new ShopItem(98, 8, "Silicon Power Slim S55", "1699", R.drawable.ssd8, "Capacity", "240 GB", "Max Sequential Write", "560 MBps", "Max Sequential Read","500 MBps"));
        shopItemList.add(new ShopItem(99, 8, "Team Group CX1", "2850", R.drawable.ssd9, "Capacity", "480 GB", "Max Sequential Write", "530 MBps", "Max Sequential Read","470 MBps"));
        shopItemList.add(new ShopItem(100, 8, "WD Blue SA510", "3899", R.drawable.ssd10, "Capacity", "500 GB", "Max Sequential Write", "560 MBps", "Max Sequential Read","510 MBps"));

        shopItemList.add(new ShopItem(101, 9, "ID-Cooling ZOOMFLOV", "13990", R.drawable.cool1, "Color", "Black", "LED Color", "ARGB", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(102, 9, "DEEPCOOL GAMMAX 300", "5990", R.drawable.cool2, "Color", "White", "LED Color", "ARGB", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(103, 9, "MSI MEG CORE LIQUID", "11990", R.drawable.cool3, "Color", "Black", "LED Color", "-", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(104, 9, "XILENCE Perfomance A+", "6990", R.drawable.cool4, "Color", "Black", "LED Color", "White", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(105, 9, "DeepCoo LT720", "5990", R.drawable.cool5, "Color", "Black", "LED Color", "ARGB", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(106, 9, "DEEPCOOL LS520 WH", "10999", R.drawable.cool6, "Color", "White", "LED Color", "ARGB", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(107, 9, "DEEPCOOL AK400 WH", "2999", R.drawable.cool7, "Color", "White", "LED Color", "", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(108, 9, "DEEPCOOL Theta 9", "699", R.drawable.cool8, "Color", "Black", "LED Color", "-", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(109, 9, "ID-COOLING DK-01", "699", R.drawable.cool9, "Color", "Black", "LED Color", "-", "Block Compatibility", "Intel, AMD"));
        shopItemList.add(new ShopItem(110, 9, "Xilence I350PWM", "799", R.drawable.cool10, "Color", "Black", "LED Color", "-", "Block Compatibility", "Intel, AMD"));
    }

    public List<ShopItem> getShopItemList() {
        return shopItemList;
    }


}
