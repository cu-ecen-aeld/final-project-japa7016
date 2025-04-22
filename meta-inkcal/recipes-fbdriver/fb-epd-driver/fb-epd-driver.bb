SUMMARY = "Out‑of‑tree E‑Paper framebuffer driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;protocol=ssh;branch=main"

PV = "1.0+git${SRCPV}"
SRCREV = "fbfef49d2383b6b915463dea0d3fc242830faede"

S = "${WORKDIR}/git/inkcal-epaper-driver"

DEPENDS = "virtual/kernel"

inherit module

<<<<<<< HEAD:meta-inkcal/recipes-fbdriver/fb-epd-driver/fb-epd-driver_1.0.bb
KERNEL_MODULE_NAME = "fb_epd"
KERNEL_MODULE_AUTOLOAD = "fb_epd"
EXTRA_OEMAKE = "-C ${STAGING_KERNEL_DIR} M=${S} KERNEL_VERSION=${KERNEL_VERSION}"
=======
KERNEL_MODULE_NAME = "fb-epd"
KERNEL_MODULE_AUTOLOAD = "fb-epd"
EXTRA_OEMAKE = "KERNEL_VERSION=${KERNEL_VERSION}"
>>>>>>> 08b52f34e1f9853ff6954161ac37d81ffb0afc32:meta-inkcal/recipes-fbdriver/fb-epd-driver/fb-epd-driver.bb

