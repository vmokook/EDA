<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Debtors</title>
            </head>
            <body>
                <a href="/xsl/apartment">Show apartments</a>
            </body>
            <body>
                <a href="/xsl/house">Show houses</a>
            </body>
        </html>
        <table border="1" style="margin-top: 5px">
            <tr bgcolor="#CCCCCC">

                <td>
                    <strong>id_house</strong>
                </td>
                <td>
                    <strong>id_number</strong>
                </td>
                <td>
                    <strong>id_apar</strong>
                </td>
                <td>
                    <strong>full_name</strong>
                </td>
                <td>
                    <strong>sex</strong>
                </td>
                <td>
                    <strong>summy</strong>
                </td>
            </tr>
            <xsl:for-each select="ArrayList/item">
                <tr>
                    <td>
                        <xsl:value-of select="id_house"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_number"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_apar"/>
                    </td>
                    <td>
                        <xsl:value-of select="full_name"/>
                    </td>
                    <td>
                        <xsl:value-of select="sex"/>
                    </td>
                    <td>
                        <xsl:value-of select="summy"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>