package com.example.lequanghoa.navigationcomponentcodelabs

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder

/**
 * App Widget that deep links you to the[DeepLinkFragment]
 */
class DeepLinkAppWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val remoteViews = RemoteViews(context.packageName, R.layout.deep_link_appwidget)

        val args = Bundle()
        args.putString("myargs", "Le Thai Bao")

        val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.mobile_navigation)
                .setDestination(R.id.android)
                .setArguments(args)
                .createPendingIntent()
        remoteViews.setOnClickPendingIntent(R.id.deep_link, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }

}