LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wifi.env \
           file://S99wifi"

RDEPENDS_${PN} = "ifupdown wpa-supplicant avahi-daemon"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d

    install -m 0644 ${WORKDIR}/wifi.env            ${D}${sysconfdir}/wifi.env
    install -m 0755 ${WORKDIR}/S99wifi             ${D}${sysconfdir}/init.d/S99wifi
}

pkg_postinst_${PN}_ontarget() {
    # Enable S99wifi at runlevel S on the actual device
    if [ -x /etc/init.d/S99wifi ]; then
        update-rc.d wifi defaults S 99 || true
    fi
    exit 0
}
