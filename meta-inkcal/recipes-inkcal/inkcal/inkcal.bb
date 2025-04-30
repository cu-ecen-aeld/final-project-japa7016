SUMMARY = "Ink-Cal e-paper calendar application"
LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;branch=master;protocol=https \
           file://inkcal.init"

PV      = "1.0+git${SRCPV}"

SRCREV  = "7f2dbea6bfebc6e96185e71c5f67362e6d774a87"

S = "${WORKDIR}/git"

inherit allarch update-rc.d             

RDEPENDS:${PN} = "python3-core python3-pillow ttf-dejavu-sans tzdata python3-spidev rpi-gpio python3-requests python3-dateutil python3-pytz python3-icalendar ntpdate ca-certificates"

PYTHON_SITEPACKAGES_DIR = "${libdir}/python3.10/site-packages"

do_install() {
    install -d  ${D}${bindir}
    install -m 0755 ${S}/inkcal.py  ${D}${bindir}/inkcal.py
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/inkcal.init  ${D}${sysconfdir}/init.d/inkcal

    install -d ${D}${PYTHON_SITEPACKAGES_DIR}/inkcal_lib
    cp -r ${S}/lib/*               ${D}${PYTHON_SITEPACKAGES_DIR}/inkcal_lib/
}


INITSCRIPT_NAME = "inkcal"
INITSCRIPT_PARAMS = "defaults 99"
FILES:${PN} += "${sysconfdir}/init.d/inkcal"
FILES:${PN} += "${bindir}/UI.py"
FILES:${PN} += "${bindir}/try.py"
FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/inkcal_lib/*"
