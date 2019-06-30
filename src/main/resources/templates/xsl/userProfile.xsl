<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" media-type="text/plain"/>

    <xsl:param name="force_password_change"/>
    <xsl:param name="new_user_request"/>
    <xsl:param name="user"/>

    <xsl:template match="/">
        <xsl:apply-templates select="loginresponsedto/user/userdto"/>
    </xsl:template>

    <xsl:template match="userdto" xmlns:util="com.gulfbank.olb.integration.commons.XslUtil">
        {
        "userprofile": {
                "identity" : "<xsl:value-of select="identity"/>",
                "refidentity" : "<xsl:value-of select="refidentity"/>",
                "refidentityprimary" : "<xsl:value-of select="refidentityprimary"/>",
                "iduser" : "<xsl:value-of select="iduser"/>",
                "nickname" : "<xsl:value-of select="nicname"/>",
                "salution" : "<xsl:value-of select="salution"/>",
                "firstname" : "<xsl:value-of select="firstname"/>",
                "name" : "<xsl:value-of select="firstname"/> <xsl:value-of select="lastname"/>",
                "lastname" : "<xsl:value-of select="lastname"/>",
                "address1" : "<xsl:value-of select="address1"/>",
                "address2" : "<xsl:value-of select="address2"/>",
                "email" : "<xsl:value-of select="email"/>",
                "city" : "<xsl:value-of select="city"/>",
                "state" : "<xsl:value-of select="state"/>",
                "country" : "<xsl:value-of select="country"/>",
                "zip" : "<xsl:value-of select="zip"/>",
                "dateofbirth" : "<xsl:value-of select="dateofbirth"/>",
                "activeflag" : "<xsl:value-of select="activeflag"/>",
                "phonenumber" : "<xsl:value-of select="phonenumber"/>",
                "faxnbr" : "<xsl:value-of select="faxnbr"/>",
                "statebit" : "<xsl:value-of select="statebit"/>",
                "datecreated" : "<xsl:value-of select="datecreated"/>",
                "markerid" : "<xsl:value-of select="markerid"/>",
                "deletecomments" : "<xsl:value-of select="deletecomments"/>",
                "usertype" : "<xsl:value-of select="usertype"/>",
                "authrequired" : "<xsl:value-of select="authrequired"/>",
                "idsegment" : "<xsl:value-of select="idsegment"/>",
                "mobnumber" : "<xsl:value-of select="mobnumber"/>",
                "force_password_change": "<xsl:value-of select="$force_password_change"/>",
                "new_user_request": "<xsl:value-of select="$new_user_request"/>",
                "lastsuccesslogin" : "<xsl:value-of
                    select="/loginresponsedto/user/userdto/userchannels/userchanneldto/datlastsuccesslogin
"/>",
                <xsl:choose>
                    <xsl:when test="/loginresponsedto/menu/menuresponsedto/menu/menudto/idtxn[text()='OLT']">"role" : "aldanah",</xsl:when>
                    <xsl:otherwise>"role" : "retail",</xsl:otherwise>
                </xsl:choose>
               <xsl:choose>
                   <xsl:when test="/loginresponsedto/udffields/udfdto/udfvalue != 0">
                       "watermarkAvailable" : "true",
                   </xsl:when>
                   <xsl:otherwise>
                       "watermarkAvailable" : "false",
                   </xsl:otherwise>
               </xsl:choose>
         "userName":"<xsl:value-of select="$user"/>",
                "txn":"<xsl:for-each select="/loginresponsedto/menu/menuresponsedto/menu/menudto">
                        <xsl:value-of select="idtxn"/><xsl:if test="position() != last()"><xsl:text>,</xsl:text></xsl:if>
                       </xsl:for-each>",
                "customers" : [
                    <xsl:for-each select="customers/customerdto">
                        {
                        "idcustomer": "<xsl:value-of select="idcustomer"/>",
                        "customerrelationtype": "<xsl:value-of select="customerrelationtype"/>",
                        "bankingunittype" : "<xsl:value-of select="bankingunittype"/>"
                        }<xsl:if test="position() != last()">,</xsl:if>
                    </xsl:for-each>
                ]
            }
        }
    </xsl:template>
</xsl:stylesheet>
