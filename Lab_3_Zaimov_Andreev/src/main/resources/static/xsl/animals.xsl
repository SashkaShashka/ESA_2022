<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <html>
            <head>
                <title class="">Animals</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
            </head>
            <body>
                <xsl:apply-templates />
            </body>
        </html>
    </xsl:template>
    <!--List for Filter and ArrayList for controller-->
    <xsl:template match="List|ArrayList">
        <div class="bg-image h-100" style="background-image: url('https://image.shutterstock.com/shutterstock/photos/794439940/display_1500/stock-vector-a-vector-illustration-of-family-adopting-a-dog-from-animal-shelter-794439940.jpg');">
            <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0,0,0,.25);">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="card bg-dark shadow-2-strong">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-dark table-borderless mb-0">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Кличка</th>
                                                    <th scope="col">Пол</th>
                                                    <th scope="col">Цвет</th>
                                                    <th scope="col">Порода</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <xsl:for-each select="item">
                                                    <tr>
                                                        <td>
                                                            <xsl:value-of select="name" />
                                                        </td>
                                                        <td>
                                                            <xsl:value-of select="sex" />
                                                        </td>
                                                        <td>
                                                            <xsl:value-of select="color" />
                                                        </td>
                                                        <td>
                                                            <xsl:value-of select="breed" />
                                                        </td>
                                                    </tr>
                                                </xsl:for-each>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </xsl:template>
    <xsl:template match="Animal">
        <div class="bg-image h-100" style="background-image: url('https://image.shutterstock.com/shutterstock/photos/794439940/display_1500/stock-vector-a-vector-illustration-of-family-adopting-a-dog-from-animal-shelter-794439940.jpg');">
            <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0,0,0,.25);">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="card bg-dark shadow-2-strong">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-dark table-borderless mb-0">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Кличка</th>
                                                    <th scope="col">Пол</th>
                                                    <th scope="col">Цвет</th>
                                                    <th scope="col">Порода</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="./name" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="./sex" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="./color" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="./breed" />
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </xsl:template>
</xsl:stylesheet>