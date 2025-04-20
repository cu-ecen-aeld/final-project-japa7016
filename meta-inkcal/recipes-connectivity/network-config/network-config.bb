LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://interfaces \
           file://wpa_supplicant.conf \
           file://wifi.env \
           file://S99wifi"

inherit update-rc.d

INITSCRIPT_NAME = "wifi"
INITSCRIPT_PARAMS = "defaults S 99"


RDEPENDS_${PN} = "ifupdown wpa-supplicant"

do_install() {
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d

    install -m 0644 ${WORKDIR}/interfaces            ${D}${sysconfdir}/network/interfaces
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf   ${D}${sysconfdir}/wpa_supplicant.conf
    install -m 0644 ${WORKDIR}/wifi.env              ${D}${sysconfdir}/wifi.env
    install -m 0755 ${WORKDIR}/S99wifi               ${D}${sysconfdir}/init.d/S99wifi
}
