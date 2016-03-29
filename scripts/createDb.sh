#!/bin/sh -e

set -e
#Drop DB named trailblazers if exits
dropdb --if-exists trailblazers

#Drop user freewheelers if exits
dropuser --if-exists freewheelers

#Creates user freewheelers
createuser -s freewheelers

#Creates DB named trailblazers
createdb trailblazers

