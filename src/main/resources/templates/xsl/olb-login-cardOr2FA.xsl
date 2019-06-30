<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>

    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="faml/response/result/resultdto/errors/errordto/errorcode !=0 or faml/response/result/resultdto/returncode != 0">
                {
                    "retry":"Y",
                    "newSecurityQns":"<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'fldRegQuesDesc']/udfvalue"/>",
                    "newSecurityQnsId":"<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'fldRegQuesId']/udfvalue"/>",
                    "message":"<xsl:value-of select="faml/response/result/resultdto/errors/errordto/errormsg"/>"
                }
            </xsl:when>
            <xsl:otherwise>
                {
                "status" : "0",
                "retry":"N",
                "idimage"  : "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idimage']/udfvalue"/>",
                "imgDesc": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'imgDesc']/udfvalue"/>",
                "idCustomer": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idCustomer']/udfvalue"/>",
                "idUser": "<xsl:value-of select="faml/response/loginresponsedto/udffields/udfdto[udfname = 'idUser']/udfvalue"/>"
                }
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>
