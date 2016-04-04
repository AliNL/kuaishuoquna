#!/bin/sh -e

set -e
#Drop DB named kuaishuoquna if exits
dropdb --if-exists kuaishuoquna

#Drop user adminYing if exits
dropuser --if-exists adminYing

#Creates user adminYing
createuser -s adminYing -W

#Creates DB named kuaishuoquna
createdb kuaishuoquna

