#!/bin/bash
# Script to build image for qemu.
# Author: Siddhant Jajoo.

git submodule init
git submodule sync
git submodule update

# local.conf won't exist until this step on first execution
source poky/oe-init-build-env

CONFLINES=(
    'MACHINE = "raspberrypi4"'
    'TARGET_ARCH = "arm"'
    'ENABLE_UART = "1"'
    'ENABLE_I2C = "1"'
    'KERNEL_MODULE_AUTOLOAD:rpi += "i2c-dev i2c-bcm2708"'
    'ENABLE_SPI_BUS = "1"'
    'KERNEL_MODULE_AUTOLOAD:rpi += "spidev"'
    'CORE_IMAGE_EXTRA_INSTALL += "spi-config"'
    'DISTRO_FEATURES_append = "wifi"'
    'IMAGE_INSTALL_append = "i2c-tools linux-firmware-rpidistro-bcm43430 v4l-utils python3 ntp wpa-supplicant"'
    'IMAGE_FEATURES += "ssh-server-openssh"'
    
)

for CONFLINE in "${CONFLINES[@]}"; do
    cat conf/local.conf | grep "${CONFLINE}" > /dev/null
    local_conf_info=$?
    
    if [ $local_conf_info -ne 0 ]; then
        echo "Append ${CONFLINE} in the local.conf file"
        echo ${CONFLINE} >> conf/local.conf
    else
        echo "${CONFLINE} already exists in the local.conf file"
    fi
done


BBLAYERS_ADD=(
    '../meta-raspberrypi'
    '../meta-openembedded'
)

for (( i = 0; i < ${#BBLAYERS_ADD[@]}; i++ )); do
    	layer="${BBLAYERS_ADD[i]}"
	bitbake-layers show-layers | grep "$(basename "$layer")" > /dev/null
	layer_info=$?

	if [ $layer_info -ne 0 ];then
		echo "Adding $layer layer"
		bitbake-layers add-layer "$layer"
	else
		echo "$layer layer already exists"
	fi
	
done

set -e
bitbake core-image-base
