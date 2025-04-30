SUMMARY = "Ink-Cal e-paper calendar application"
LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;branch=master;protocol=https \
           file://inkcal.init"

PV      = "1.0+git${SRCPV}"

SRCREV  = "f9a27d9e7df0538fef52cde10d3a5d381a7b3891"

S = "${WORKDIR}/git"

inherit allarch update-rc.d             

RDEPENDS:${PN} = "python3-core python3-pillow ttf-dejavu-sans tzdata python3-spidev rpi-gpio"

do_install() {
    install -d  ${D}${bindir}
    install -m 0755 ${S}/UI.py  ${D}${bindir}/UI.py
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/inkcal.init  ${D}${sysconfdir}/init.d/inkcal

    install -d ${D}${bindir}/lib  
    cp -r ${S}/lib/*  ${D}${bindir}/lib/
}


INITSCRIPT_NAME = "inkcal"
INITSCRIPT_PARAMS = "defaults 99"
FILES:${PN} += "${bindir}/lib/*"
FILES:${PN} += "${sysconfdir}/init.d/inkcal"
FILES:${PN} += "${bindir}/UI.py"
FILES:${PN} += "${bindir}/try.py"
