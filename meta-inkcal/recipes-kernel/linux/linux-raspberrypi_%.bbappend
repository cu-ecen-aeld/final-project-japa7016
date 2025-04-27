FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DEPENDS:append         = " dtc-native"
SRC_URI:append         = " file://epd-overlay.dts"
RPI_KERNEL_DEVICETREE_OVERLAYS:append = " epd-overlay"

