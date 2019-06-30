<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>

    <xsl:param name="showDisclaimer"/>
    <xsl:param name="showSecurityQuestion"/>
    <xsl:param name="disclaimerMessage"/>
    <xsl:param name="jsessionid"/>

    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="faml/response/result/resultdto/errors/errordto/errorcode !=0 or faml/response/result/resultdto/returncode != 0">
                {
                    "errors"  : [
                        {
                            "message" : "<xsl:value-of select="faml/response/result/resultdto/errors/errordto/errormsg"/>",
                            "code"    : "<xsl:value-of select="faml/response/result/resultdto/errors/errordto/errorcode"/>",
                            "haha"   : "hahah"
                        }
                    ]
                }
            </xsl:when>
            <xsl:otherwise>
                {
                    "status" : "0",
                    "idimage"  : "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idimage']/udfvalue"/>",
                    "imgDesc": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'imgDesc']/udfvalue"/>",
                    "deleteFlag": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'deleteFlag']/udfvalue"/>",
                    "lockFlag": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'lockFlag']/udfvalue"/>",
                    "activeFlag": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'activeFlag']/udfvalue"/>",
                    "isRegisteredFor2FA": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'isRegisteredFor2FA']/udfvalue"/>",
                    "isRegisteredForSecQns":"<xsl:value-of select="string($showSecurityQuestion)"/>",
                    "showDisclaimer":"<xsl:value-of select="string($showDisclaimer)"/>",
                    "disclaimerMessage":"<xsl:value-of select="string($disclaimerMessage)"/>",
                    "securityQuestion":"<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'fldRegQuesDesc']/udfvalue"/>",
                    "securityQuestionID":"<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'fldRegQuesId']/udfvalue"/>",
                    "idCustomer": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idCustomer']/udfvalue"/>",
                    "idUser": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idUser']/udfvalue"/>",
                    "sessionId": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'SessionId']/udfvalue"/>",
                    "jsessionId": "<xsl:value-of select="$jsessionid"/>"
                                   }
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>
