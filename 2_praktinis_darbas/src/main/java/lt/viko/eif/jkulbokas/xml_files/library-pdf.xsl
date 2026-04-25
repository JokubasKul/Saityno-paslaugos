<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                version="1.0">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">

        <fo:root>

            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4"
                                       page-height="29.7cm"
                                       page-width="21cm"
                                       margin="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block font-size="18pt" font-weight="bold" space-after="10pt">
                        Library pdf
                    </fo:block>


                    <xsl:for-each select="library/shelf">
                        <fo:block font-size="14pt" font-weight="bold" space-before="10pt" space-after="5pt">
                            <xsl:value-of select="category"/>
                        </fo:block>

                        <fo:table border="1pt solid black" width="100%">
                            <fo:table-column column-width="4cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-column column-width="6cm"/>


                            <fo:table-header>
                                <fo:table-row>
                                    <fo:table-cell padding-bottom="10pt">
                                        <fo:block font-weight="bold">Title</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-bottom="10pt">
                                        <fo:block font-weight="bold">Year</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-bottom="10pt">
                                        <fo:block font-weight="bold">Author</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>

                            <fo:table-body>
                                <xsl:for-each select="books/book">
                                    <fo:table-row>
                                        <fo:table-cell padding-bottom="5pt">
                                            <fo:block><xsl:value-of select="title"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-bottom="5pt">
                                            <fo:block><xsl:value-of select="release_year"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-bottom="5pt">
                                            <fo:block><xsl:value-of select="author"/></fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                            </fo:table-body>

                        </fo:table>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>