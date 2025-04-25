SUMMARY = "Out‑of‑tree E‑Paper framebuffer driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/japa7016/ink-cal-application.git;protocol=ssh;branch=main"
SRC_URI += " file://epd-overlay.dts"

PV = "1.0+git${SRCPV}"
SRCREV = "12c09fce722b5c9b52c187048985e593072f72d1"

S = "${WORKDIR}/git/inkcal-epaper-driver"

DEPENDS = "virtual/kernel dtc-native"

inherit module 

KERNEL_MODULE_NAME = "fb-epd"
KERNEL_MODULE_AUTOLOAD = "fb-epd"
EXTRA_OEMAKE = "-C ${STAGING_KERNEL_DIR} M=${S} KERNEL_VERSION=${KERNEL_VERSION}"

do_compile:append() {  
     dtc -@ -I dts -O dtb -o ${WORKDIR}/epd-overlay.dtbo   ${WORKDIR}/epd-overlay.dts  
}

do_install:append() {  
     install -d ${D}/boot/overlays
     install -m 0644 ${WORKDIR}/epd-overlay.dtbo  ${D}/boot/overlays/epd-overlay.dtbo  
}  
