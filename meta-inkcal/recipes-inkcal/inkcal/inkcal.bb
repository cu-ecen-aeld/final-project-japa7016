SUMMARY = "Ink-Cal e-paper calendar application"
LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;branch=master;protocol=https"

PV      = "1.0+git${SRCPV}"

SRCREV  = "b2788d81b52b8e42060217138f7d5074f38de271"

S = "${WORKDIR}/git"

inherit allarch             

RDEPENDS:${PN} = "python3-core python3-pillow python3-stdlib-modules"

do_install() {
    install -d  ${D}${bindir}
    install -m 0755 ${S}/UI_temp.py ${D}${bindir}/UI_temp.py
}

