LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wifi.env \
           file://S99wifi  \
           file://S98fbepd"

RDEPENDS_${PN} = "ifupdown wpa-supplicant avahi-daemon"

do_install:append() {
    install -d ${D}${sysconfdir}/rcS.d

    install -m 0644 ${WORKDIR}/wifi.env            ${D}${sysconfdir}/wifi.env
    install -m 0755 ${WORKDIR}/S99wifi             ${D}${sysconfdir}/rcS.d/S99wifi
    install -m 0755 ${WORKDIR}/S98fbepd            ${D}${sysconfdir}/rcS.d/S98fbepd
}


