SUMMARY = "Out‑of‑tree E‑Paper framebuffer driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;protocol=ssh;branch=main"

PV = "1.0+git${SRCPV}"
SRCREV = "12c09fce722b5c9b52c187048985e593072f72d1"

S = "${WORKDIR}/git/inkcal-epaper-driver"

DEPENDS = "virtual/kernel"

inherit module 

KERNEL_MODULE_NAME = "fb-epd"
KERNEL_MODULE_AUTOLOAD = "fb-epd"
EXTRA_OEMAKE = "-C ${STAGING_KERNEL_DIR} M=${S} KERNEL_VERSION=${KERNEL_VERSION}"

<<<<<<< HEAD
=======
FILES_${PN} += " \
     ${sysconfdir} \
     ${sysconfdir}/rcS.d \
     ${sysconfdir}/rcS.d/S98fbepd \
 "

INSANE_SKIP_${PN} += "installed-vs-shipped"

do_install:append() {
    install -d ${D}${sysconfdir}/rcS.d
    install -m 0755 ${WORKDIR}/S98fbepd ${D}${sysconfdir}/rcS.d/S98fbepd
>>>>>>> 8848edc09cbc694c06c52a4f83cd17bee131bed5

