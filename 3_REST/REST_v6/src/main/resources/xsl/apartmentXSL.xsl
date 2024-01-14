<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Apartments</title>
            </head>
            <body>
<<<<<<< HEAD
                <a href="/xsl/debtor">Show debtors</a>
            </body>
            <body>
                <a href="/xsl/house">Show houses</a>
=======
                <a href="/xsl/orders">Show apartments</a>
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
            </body>
        </html>
        <table border="1" style="margin-top: 5px">
            <tr bgcolor="#CCCCCC">
                <td>
<<<<<<< HEAD
                    <strong>id_house</strong>
                </td>
                <td>
                    <strong>id_apar</strong>
                </td>
            </tr>
            <xsl:for-each select="ArrayList/item">
                <tr>
                    <td>
                        <xsl:value-of select="id_house"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_apar"/>
=======
                    <strong>id_apar</strong>
                </td>
                <td>
                    <strong>id_house</strong>
                </td>
            </tr>
            <xsl:for-each select="List/item">
                <tr>
                    <td>
                        <xsl:value-of select="id_apar"/>
                    </td>
                    <td>
                        <xsl:value-of select="id_house"/>
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>