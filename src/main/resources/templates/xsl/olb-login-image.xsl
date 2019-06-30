<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>

    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="faml/response/result/resultdto/errors and faml/response/result/resultdto/returncode != 0">
                {
                    "errors"  : [
                        {
                            "message" : "<xsl:value-of select="faml/response/result/resultdto/errors/errordto/errormsg"/>",
                            "code"    : "<xsl:value-of select="faml/response/result/resultdto/errors/errordto/errorcode"/>"
                        }
                    ]
                }
            </xsl:when>
            <xsl:otherwise>
                {
                    "status" : "SUCCESS",
                    "idUser"  : "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idUser']/udfvalue"/>",
                    "message" : "<xsl:value-of select="faml/response/result/resultdto/resultmsgs/resultmsgdto/msg"/>"
                }
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>
