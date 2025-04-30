SUMMARY = "iCalendar Library for Python"
HOMEPAGE = "https://github.com/collective/icalendar"
LICENSE  = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=1b2957cd26c589d0defcb357be630e80"

SRC_URI[md5sum] = "37d46cd3f0c8a04e97f57c5f0efe1c5a"
SRC_URI[sha256sum] = "cabfa6b800072318d7a4b415786bdd30129618afa4620ea55b99c656d85ea22d"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pytz"
PYPI_PACKAGE = "icalendar"
PV = "5.0.0"
