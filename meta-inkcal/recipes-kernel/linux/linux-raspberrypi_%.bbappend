FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
DEPENDS:append         = " dtc-native"
SRC_URI:append         = " file://overlays/epd-overlay.dts"
RPI_KERNEL_DEVICETREE_OVERLAYS:append = " overlays/epd-overlay.dtbo"


do_configure:prepend() {
    install -m 0644 ${WORKDIR}/overlays/epd-overlay.dts ${S}/arch/arm/boot/dts/overlays/epd-overlay.dts
}

do_deploy:append() {
    install -D -m 0644 ${B}/arch/arm/boot/dts/overlays/epd-overlay.dtbo ${DEPLOYDIR}/overlays/epd-overlay.dtbo
}
