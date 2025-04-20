inherit core-image
inherit extrausers

SUMMARY = "InkCal image: InkCal app + auto‑WiFi on boot"
LICENSE = "CLOSED"

CORE_IMAGE_EXTRA_INSTALL += "network-config"

PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"

