package com.github.chuross.trancebaka.infrastructure.soundcloud

import com.fasterxml.jackson.databind.ObjectMapper
import java.text.SimpleDateFormat

class SoundCloudObjectMapper : ObjectMapper {

    constructor() {
        dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z");
    }
}