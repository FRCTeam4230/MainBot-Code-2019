#!/bin/bash
set -e

# WPILIB download link
WPILIB_VERSION=2019.2.1
WPILIB_PACKAGE="WPILib_Linux-${WPILIB_VERSION}.tar.gz"
WPILIB_URL_BASE="https://github.com/wpilibsuite/allwpilib/releases/download/"
WPILIB_URL="${WPILIB_URL_BASE}/v${WPILIB_VERSION}/${WPILIB_PACKAGE}"
echo -e "Installing WPILib"
wget $WPILIB_URL -O wpilib.tar.gz
mkdir -p wpilib
tar -xzf "wpilib.tar.gz" -C wpilib
ls -lah
export JAVA_HOME="$TRAVIS_BUILD_DIR/wpilib/jdk"

