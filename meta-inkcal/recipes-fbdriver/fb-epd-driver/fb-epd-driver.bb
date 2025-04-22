SUMMARY = "Out‑of‑tree E‑Paper framebuffer driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;protocol=ssh;branch=main"

PV = "1.0+git${SRCPV}"
SRCREV = "9f9648872bfcb80a81c1644d2b31ac876d64a7f0"

S = "${WORKDIR}/git/inkcal-epaper-driver"

DEPENDS = "virtual/kernel"

inherit module

KERNEL_MODULE_NAME = "fb-epd"
KERNEL_MODULE_AUTOLOAD = "fb-epd"
EXTRA_OEMAKE = "-C ${STAGING_KERNEL_DIR} M=${S} KERNEL_VERSION=${KERNEL_VERSION}"


