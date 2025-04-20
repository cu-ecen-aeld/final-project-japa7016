inherit core-image
inherit extrausers

SUMMARY = "InkCal image: InkCal app + auto‑WiFi on boot"
LICENSE = "CLOSED"

CORE_IMAGE_EXTRA_INSTALL += "network-config"

PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"

ROOTFS_POSTPROCESS_COMMAND += "override_configs;"


override_configs() {
    install -d ${IMAGE_ROOTFS}/etc
    cp ${THISDIR}/files/hostname   ${IMAGE_ROOTFS}/etc/hostname
    install -d ${IMAGE_ROOTFS}/etc/network
    cp ${THISDIR}/files/interfaces ${IMAGE_ROOTFS}/etc/network/interfaces
}

