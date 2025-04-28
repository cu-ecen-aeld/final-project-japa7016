SUMMARY = "Out‑of‑tree E‑Paper framebuffer driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;protocol=ssh;branch=main"

PV = "1.0+git${SRCPV}"
<<<<<<< HEAD
SRCREV = "f76863f3e7baed344bdf6dad4a9c2f64713b338f"
=======
SRCREV = "bb3a486840bbb9cb070f077e2db4298b2a09d90f"
>>>>>>> 5bdd5ab271116764062a6886687ff4194008f4d9

S = "${WORKDIR}/git/inkcal-epaper-driver"

DEPENDS = "virtual/kernel dtc-native"

inherit module 

KERNEL_MODULE_NAME = "fb-epd"
KERNEL_MODULE_AUTOLOAD = "fb-epd"
EXTRA_OEMAKE = "-C ${STAGING_KERNEL_DIR} M=${S} KERNEL_VERSION=${KERNEL_VERSION}"

