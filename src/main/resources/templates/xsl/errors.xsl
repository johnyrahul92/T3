<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>
    <xsl:template match="/" xmlns:util="com.GBKT3.GBKT3.util.XslUtil">
        {        
        "errors": [
        <xsl:for-each select="faml/response/result/resultdto/errors/errordto">
            {
            "code": "<xsl:value-of select="errorcode"/>",
            "message": "<xsl:value-of select="util:encodeJson(errormsg)"/>"
            }
            <xsl:if test="position() != last()">,</xsl:if>
        </xsl:for-each>

        ]
        }
    </xsl:template>
</xsl:stylesheet>
