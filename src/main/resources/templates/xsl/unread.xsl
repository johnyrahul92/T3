<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>
    <xsl:template match="/" >
        {
        "unreadCount": "<xsl:value-of select="faml/response/internalmessageserviceresponsedto/totalunreadcount"/>"
        }
    </xsl:template>
</xsl:stylesheet>
