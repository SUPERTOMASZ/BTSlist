package GPSHelper;

import com.example.btsmaintenancesystem.GpsActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class GPSHelper extends Service implements LocationListener
{

	private Context context;
	private boolean isGPSEnabled=false;
	private boolean isNetworkEnabled=false;
	private boolean canGetLocation=false;
	private Location location;
	private double latitude;//szerokosc geo wspX
	private double longitude;//dlugosc geo wspY
	private GpsActivity gpsAc;
	
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES=10;
	private static final long MIN_TIMES_BW_UPDATES=100*60*1;
	
	protected LocationManager locationManager;
	
	public GPSHelper(Context context,GpsActivity gpsAc)
	{
		this.context=context;
		this.gpsAc=gpsAc;
		getLocation();
	
	}
	
	public Location getLocation()
	{
		this.locationManager= (LocationManager) 
							context.getSystemService(LOCATION_SERVICE);
		isGPSEnabled=this.locationManager.
							isProviderEnabled(LocationManager.GPS_PROVIDER);
		isNetworkEnabled=this.locationManager.
							isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		
		if(!isGPSEnabled && !isNetworkEnabled)
		{
			
			Log.i("GPSHelper","brak mozliwosci lokalizacji");
			
		}
		else
		{
			
			if(isNetworkEnabled)
			{
				Log.i("GPSHelper","mozliwosc zlokalizowania przez siec");
				locationManager.requestLocationUpdates
				(LocationManager.NETWORK_PROVIDER,
				 MIN_TIMES_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
				 if(locationManager!=null)
				 {
					 Log.i("GPSHelper","siec udalo sie ");
					 
					 location=locationManager.getLastKnownLocation
							 				(LocationManager.NETWORK_PROVIDER);
					 if(location!=null)
					 {
						 this.canGetLocation=true;
						 Log.i("GPSHelper","siec , pobrano location");
						 latitude=location.getLatitude();
						 longitude=location.getLongitude();
					 }
					 
				 }
				
				
			}
			if(isGPSEnabled)
			{
				Log.i("GPSHelper","mozliwosc zlokalizowania przez gps");
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
							MIN_TIMES_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES,
									this);

				if(locationManager!=null)
				{
					 Log.i("GPSHelper","gps udalo sie ");
					location=locationManager.getLastKnownLocation
							(LocationManager.GPS_PROVIDER);
					if(location!=null)
					{
						this.canGetLocation=true;
						Log.i("GPSHelper","gps , pobrano location");
						latitude=location.getLatitude();
						 longitude=location.getLongitude();
					}
				}
		
				
			}
			
		}
		return location;
		
	}
	
	public void stopUsingGPS()
	{
		if(locationManager!=null)
			locationManager.removeUpdates(this);
	}
	
	public double getLatitude()
	{
		if(location!=null)
			return latitude;
		else
			return -1;
	}
	public double getLongitude()
	{
		if(location!=null)
			return longitude;
		else
			return -1;
	}
	public boolean canGetLocation()
	{
        return this.canGetLocation;
    }

	public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
      
        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
  
        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
  
        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });
  
        // Showing Alert Message
        alertDialog.show();
    }
	
	
	@Override
	public void onLocationChanged(Location location) {
		Log.i("GPSHelper", "On location changed");
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		Log.i("GPSHelper", "On provider disabled"+provider);
		
	}
	@Override
	public void onProviderEnabled(String provider) {
		Log.i("GPSHelper", "On provider enabled"+provider);
		//getLocation();
		//gpsAc.makeList();
		Log.i("GPSHelper"," kazalem zrobic liste");
		//gpsAc.getCustomListView().notifyDataSetChanged();
		
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Log.i("GPSHelper", "status changed");
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("GPSHelper", "bind ");
		return null;
	}

}
