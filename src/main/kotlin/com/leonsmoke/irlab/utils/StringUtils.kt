package com.leonsmoke.irlab.utils

import org.springframework.web.bind.annotation.RequestBody

class StringUtils {

    companion object {
        fun resolveNickname(body: String): String {
            var indexFrom: Int = body.indexOf("nickname") + 10;
            indexFrom = body.indexOf('"',indexFrom)+1;
            var indexTo: Int = body.indexOf('"',indexFrom);
            return body.substring(indexFrom,indexTo);
        }
    }

}