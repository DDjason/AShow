package com.example.ashow;

import java.util.ArrayList;
import java.util.List;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import android.app.Activity;
import android.content.Context;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class Baishowmap extends Activity{
	private MapView mapView;
	private BaiduMap baidumap;
	private LocationManager locationmanger;
	private String provider;
	private boolean isFirstLocation = true;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.baishowmap);
		mapView = (MapView)findViewById(R.id.map_view);
		baidumap = mapView.getMap();
		//////////////////////////////
		

		
		
		////////////////////////
		baidumap.setBuildingsEnabled(true);
		
		locationmanger = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		//获取为知提供器
		
		List<String>providerList = locationmanger.getProviders(true);
		
		if(providerList.contains(LocationManager.GPS_PROVIDER)){
			provider = LocationManager.GPS_PROVIDER;
		}else if(providerList.contains(LocationManager.NETWORK_PROVIDER)){
			provider = LocationManager.NETWORK_PROVIDER;
		}else{
			Toast.makeText(this, "NO LOCATION PROVIDER TO USE", Toast.LENGTH_SHORT).show();
			return;
		}
		
		Location location = locationmanger.getLastKnownLocation(provider);
		
		if(location != null){
			navigateTo(location);
		}
		locationmanger.requestLocationUpdates(provider, 5000, 1, locationListener);
	}
	
	private void navigateTo(Location location){
		if(isFirstLocation){
			LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());
			MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
			baidumap.animateMapStatus(update);
			update = MapStatusUpdateFactory.zoomTo(16f);
			baidumap.animateMapStatus(update);
			isFirstLocation = false;
		}
		
		MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
		locationBuilder.latitude(location.getLatitude());
		locationBuilder.longitude(location.getLongitude());
		MyLocationData locationData = locationBuilder.build();
		baidumap.setMyLocationData(locationData);
		
		showSomeMyLocation();
		baidumap.setOnMarkerClickListener(new OnMarkerClickListener() {  
		      
		    @Override  
		    public boolean onMarkerClick(Marker arg0) {  
		        // TODO Auto-generated method stub  
		        Toast.makeText(getApplicationContext(), arg0.getTitle()+"被点击了！", Toast.LENGTH_SHORT).show();  
		        return false;  
		    }  
		});  
	
		
	}
	
	private void showSomeMyLocation(){
		
		
		List<LatLng> LLlist = new ArrayList<LatLng>();
		//经纬度地址  ()写成从文件读取()
				//LatLng latLng = baidumap.getMapStatus().target;  
				LatLng latLng = new LatLng(30.2620750000,119.7355390000);
				LLlist.add(latLng);
				 latLng = new LatLng(30.2641030000,119.7308860000);
				LLlist.add(latLng);
				latLng = new LatLng(30.2655530000,119.7363470000);
				LLlist.add(latLng);
				latLng = new LatLng(30.2602500000,119.7330420000);
				LLlist.add(latLng);
				latLng = new LatLng(30.2593770000,119.7381080000);
				LLlist.add(latLng);
				//准备 marker 的图片  
				BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);  
				//准备 marker option 添加 marker 使用  
				MarkerOptions markerOptions;
				Marker marker = null;
				for(int i = 0 ; i < LLlist.size();i++){
				markerOptions = new MarkerOptions().icon(bitmap).position(LLlist.get(i));  
				//获取添加的 marker 这样便于后续的操作  
				
				 marker = (Marker) baidumap.addOverlay(markerOptions);  
				 
				 marker.setTitle("marker"+i);
				}
				
				
		
	}
	
	LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
			
		}
		
		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			if(location !=null ){
				navigateTo(location);
			}
			
		}
	};
	protected void onDestory(){
		super.onDestroy();
		baidumap.setBuildingsEnabled(false);
		mapView.onDestroy();
		if(locationmanger != null){
			locationmanger.removeUpdates(locationListener);
		}
	}
	protected void onPause(){
		super.onPause();
		mapView.onPause();
	}
	protected void onResume(){
		super.onResume();
		mapView.onResume();
	}
	
}
