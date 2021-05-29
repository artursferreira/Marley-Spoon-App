package com.artur.marleyspoon.main.data.repository.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipesResponse(
    @SerializedName("includes")
    val includes: Includes?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("sys")
    val sys: Sys?,
    @SerializedName("total")
    val total: Int?
) : Parcelable {
    @Parcelize
    data class Includes(
        @SerializedName("Asset")
        val asset: ArrayList<Asset?>,
        @SerializedName("Entry")
        val entry: ArrayList<Entry?>
    ) : Parcelable {

        @Parcelize
        data class Asset(
            @SerializedName("fields")
            val fields: Fields?,
            @SerializedName("sys")
            val sys: Sys?
        ) : Parcelable {
            @Parcelize
            data class Fields(
                @SerializedName("file")
                val `file`: File?,
                @SerializedName("title")
                val title: String?
            ) : Parcelable {
                @Parcelize
                data class File(
                    @SerializedName("contentType")
                    val contentType: String?,
                    @SerializedName("details")
                    val details: Details?,
                    @SerializedName("fileName")
                    val fileName: String?,
                    @SerializedName("url")
                    val url: String?
                ) : Parcelable {

                    @Parcelize
                    data class Details(
                        @SerializedName("image")
                        val image: Image?,
                        @SerializedName("size")
                        val size: Int?
                    ) : Parcelable {

                        @Parcelize
                        data class Image(
                            @SerializedName("height")
                            val height: Int?,
                            @SerializedName("width")
                            val width: Int?
                        ) : Parcelable
                    }
                }
            }

            @Parcelize
            data class Sys(
                @SerializedName("createdAt")
                val createdAt: String?,
                @SerializedName("environment")
                val environment: Environment?,
                @SerializedName("id")
                val id: String?,
                @SerializedName("locale")
                val locale: String?,
                @SerializedName("revision")
                val revision: Int?,
                @SerializedName("space")
                val space: Space?,
                @SerializedName("type")
                val type: String?,
                @SerializedName("updatedAt")
                val updatedAt: String?
            ) : Parcelable {
                @Parcelize
                data class Environment(
                    @SerializedName("sys")
                    val sys: Sys?
                ) : Parcelable {

                    @Parcelize
                    data class Sys(
                        @SerializedName("id")
                        val id: String?,
                        @SerializedName("linkType")
                        val linkType: String?,
                        @SerializedName("type")
                        val type: String?
                    ) : Parcelable
                }

                @Parcelize
                data class Space(
                    @SerializedName("sys")
                    val sys: Sys?
                ) : Parcelable {

                    @Parcelize
                    data class Sys(
                        @SerializedName("id")
                        val id: String?,
                        @SerializedName("linkType")
                        val linkType: String?,
                        @SerializedName("type")
                        val type: String?
                    ) : Parcelable
                }
            }
        }

        @Parcelize
        data class Entry(
            @SerializedName("fields")
            val fields: Fields?,
            @SerializedName("sys")
            val sys: Sys?
        ) : Parcelable {

            @Parcelize
            data class Fields(
                @SerializedName("name")
                val name: String?
            ) : Parcelable

            @Parcelize
            data class Sys(
                @SerializedName("contentType")
                val contentType: ContentType?,
                @SerializedName("createdAt")
                val createdAt: String?,
                @SerializedName("environment")
                val environment: Environment?,
                @SerializedName("id")
                val id: String?,
                @SerializedName("locale")
                val locale: String?,
                @SerializedName("revision")
                val revision: Int?,
                @SerializedName("space")
                val space: Space?,
                @SerializedName("type")
                val type: String?,
                @SerializedName("updatedAt")
                val updatedAt: String?
            ) : Parcelable {
                @Parcelize
                data class ContentType(
                    @SerializedName("sys")
                    val sys: Sys?
                ) : Parcelable {

                    @Parcelize
                    data class Sys(
                        @SerializedName("id")
                        val id: String?,
                        @SerializedName("linkType")
                        val linkType: String?,
                        @SerializedName("type")
                        val type: String?
                    ) : Parcelable
                }

                @Parcelize
                data class Environment(
                    @SerializedName("sys")
                    val sys: Sys?
                ) : Parcelable {

                    @Parcelize
                    data class Sys(
                        @SerializedName("id")
                        val id: String?,
                        @SerializedName("linkType")
                        val linkType: String?,
                        @SerializedName("type")
                        val type: String?
                    ) : Parcelable
                }

                @Parcelize
                data class Space(
                    @SerializedName("sys")
                    val sys: Sys?
                ) : Parcelable {

                    @Parcelize
                    data class Sys(
                        @SerializedName("id")
                        val id: String?,
                        @SerializedName("linkType")
                        val linkType: String?,
                        @SerializedName("type")
                        val type: String?
                    ) : Parcelable
                }
            }
        }
    }

    @Parcelize
    data class Item(
        @SerializedName("fields")
        val fields: Fields?,
        @SerializedName("sys")
        val sys: Sys?
    ) : Parcelable {

        @Parcelize
        data class Fields(
            @SerializedName("calories")
            val calories: Int?,
            @SerializedName("chef")
            val chef: Chef?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("photo")
            val photo: Photo?,
            @SerializedName("tags")
            val tags: List<Tag?>?,
            @SerializedName("title")
            val title: String?
        ) : Parcelable {
            @Parcelize
            data class Chef(
                @SerializedName("sys")
                val sys: Sys?
            ) : Parcelable {

                @Parcelize
                data class Sys(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("linkType")
                    val linkType: String?,
                    @SerializedName("type")
                    val type: String?
                ) : Parcelable
            }

            @Parcelize
            data class Photo(
                @SerializedName("sys")
                val sys: Sys?
            ) : Parcelable {

                @Parcelize
                data class Sys(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("linkType")
                    val linkType: String?,
                    @SerializedName("type")
                    val type: String?
                ) : Parcelable
            }

            @Parcelize
            data class Tag(
                @SerializedName("sys")
                val sys: Sys?
            ) : Parcelable {

                @Parcelize
                data class Sys(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("linkType")
                    val linkType: String?,
                    @SerializedName("type")
                    val type: String?
                ) : Parcelable
            }
        }

        @Parcelize
        data class Sys(
            @SerializedName("contentType")
            val contentType: ContentType?,
            @SerializedName("createdAt")
            val createdAt: String?,
            @SerializedName("environment")
            val environment: Environment?,
            @SerializedName("id")
            val id: String?,
            @SerializedName("locale")
            val locale: String?,
            @SerializedName("revision")
            val revision: Int?,
            @SerializedName("space")
            val space: Space?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("updatedAt")
            val updatedAt: String?
        ) : Parcelable {

            @Parcelize
            data class ContentType(
                @SerializedName("sys")
                val sys: Sys?
            ) : Parcelable {
                @Parcelize
                data class Sys(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("linkType")
                    val linkType: String?,
                    @SerializedName("type")
                    val type: String?
                ) : Parcelable
            }

            @Parcelize
            data class Environment(
                @SerializedName("sys")
                val sys: Sys?
            ) : Parcelable {
                @Parcelize
                data class Sys(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("linkType")
                    val linkType: String?,
                    @SerializedName("type")
                    val type: String?
                ) : Parcelable
            }

            @Parcelize
            data class Space(
                @SerializedName("sys")
                val sys: Sys?
            ) : Parcelable {
                @Parcelize
                data class Sys(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("linkType")
                    val linkType: String?,
                    @SerializedName("type")
                    val type: String?
                ) : Parcelable
            }
        }
    }

    @Parcelize
    data class Sys(
        @SerializedName("type")
        val type: String?
    ) : Parcelable

}