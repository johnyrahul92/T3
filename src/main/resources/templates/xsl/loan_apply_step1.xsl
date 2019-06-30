<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>
    <xsl:param name="lang"/>
    <xsl:param name="fullName"/>

    <xsl:template match="/" xmlns:util="com.gulfbank.olb.integration.commons.XslUtil">
        {
            "name":"<xsl:value-of select="$fullName"/>",
            "civilId":"<xsl:value-of select="//faml/response/loandetailsresponsedto/civilid"/>",
            "nationality":"<xsl:value-of select="//faml/response/loandetailsresponsedto/nationality"/>",
            "loanType":
            [

        <xsl:for-each select="faml/response/loandetailsresponsedto/loanparameters/loanparametersdto">
            {
            "code": "<xsl:value-of select="loantype"/>",
            <xsl:if test="$lang = 'eng'">
                "type": "<xsl:value-of select="loannameeng"/>",
            </xsl:if>
            <xsl:if test="$lang != 'eng'">
                "type": "<xsl:value-of select="loannameara"/>",
            </xsl:if>
            "minLimit": "<xsl:value-of select="minloanlimit"/>",
            "maxLimit":"<xsl:value-of select="maxloanlimit"/>",
            "minPeriod":"<xsl:value-of select="loanperiodmin"/>",
            "maxPeriod":"<xsl:value-of select="loanperiodmax"/>" ,            
            "isStaffAllowed": "<xsl:value-of select="isstaffallowed"/>"

            }
            <xsl:if test="position() != last()">,</xsl:if>
        </xsl:for-each>

            ],
            "employmentType":
            [
        <xsl:for-each select="faml/response/loandetailsresponsedto/emptype/datadto">
            {
            "type": "<xsl:value-of select="description"/>",
            "code": "<xsl:value-of select="code"/>"
            }
            <xsl:if test="position() != last()">,</xsl:if>
        </xsl:for-each>
            ],
            "loanPurpose":
             
            [
             <xsl:for-each select="faml/response/loandetailsresponsedto/loanpurpose/datadto">
             {
                "description": "<xsl:value-of select="description"/>",
            	"code": "<xsl:value-of select="code"/>"
            }
            <xsl:if test="position() != last()">,</xsl:if>
             </xsl:for-each>
            ]
           
        }
    </xsl:template>

</xsl:stylesheet>
