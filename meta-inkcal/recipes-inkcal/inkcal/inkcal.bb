SUMMARY = "Ink-Cal test display script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    git://github.com/japa7016/ink-cal-application.git;protocol=ssh;branch=main;subdir=ink-cal-application \
"
PV = "1.0+git${SRCPV}"
SRCREV = "bb3a486840bbb9cb070f077e2db4298b2a09d90f"


S = "${WORKDIR}/ink-cal-application/test"

inherit allarch


RDEPENDS_${PN} = " \
    python3 \
    python3-pillow \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/test-display.py ${D}${bindir}/test-display.py
}

FILES_${PN} += "${bindir}/test-display.py"

