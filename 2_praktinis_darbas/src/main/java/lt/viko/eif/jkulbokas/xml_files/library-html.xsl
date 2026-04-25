<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Library html</title>
                <style>
                    body { font-family: Arial; }
                    h2 { color: black; }
                    table { border-collapse: collapse; margin-bottom: 20px; width: 80%; }
                    th, td { border: 1px solid black; padding: 8px; text-align: left; }
                    th { background-color: #dddddd; }
                </style>
            </head>

            <body>
                <h1>Library data</h1>

                <xsl:for-each select="library/shelf">
                    <h2><xsl:value-of select="category"/></h2>

                    <table>
                        <tr>
                            <th>Title</th>
                            <th>Release Year</th>
                            <th>Author</th>
                        </tr>
                        <xsl:for-each select="books/book">
                            <tr>
                                <td><xsl:value-of select="title"/></td>
                                <td><xsl:value-of select="release_year"/></td>
                                <td><xsl:value-of select="author"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </xsl:for-each>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>