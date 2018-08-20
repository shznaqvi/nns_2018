package edu.aku.hassannaqvi.nns_2018.WifiDirect;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import edu.aku.hassannaqvi.nns_2018.DataTransfers.transferAnthro;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.WifiDirect.DeviceListFragment.DeviceActionListener;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;

/**
 * A fragment that manages a particular peer and allows interaction with device
 * i.e. setting up network connection and transferring data.
 */
public class DeviceDetailFragment extends Fragment implements ConnectionInfoListener {

    protected static final int CHOOSE_FILE_RESULT_CODE = 20;
    ProgressDialog progressDialog = null;
    private View mContentView = null;
    private WifiP2pDevice device;
    private WifiP2pInfo info;
    DatabaseHelper db;

    public static boolean copyFile(InputStream inputStream, OutputStream out) {
        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                out.write(buf, 0, len);

            }
            out.close();
            inputStream.close();
        } catch (IOException e) {
            Log.d(WiFiDirectActivity.TAG, e.toString());
            return false;
        }
        return true;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        db = new DatabaseHelper(getActivity());

        mContentView = inflater.inflate(R.layout.device_detail, null);
        mContentView.findViewById(R.id.btn_connect).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                WifiP2pConfig config = new WifiP2pConfig();
                config.deviceAddress = device.deviceAddress;
                config.groupOwnerIntent = 0;

                config.wps.setup = WpsInfo.PBC;
                config.groupOwnerIntent = 0;
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                progressDialog = ProgressDialog.show(getActivity(), "Press back to cancel",
                        "Connecting to :" + device.deviceAddress, true, true
//                        new DialogInterface.OnCancelListener() {
//
//                            @Override
//                            public void onCancel(DialogInterface dialog) {
//                                ((DeviceActionListener) getActivity()).cancelDisconnect();
//                            }
//                        }
                );
                ((DeviceActionListener) getActivity()).connect(config);

            }
        });

        mContentView.findViewById(R.id.btn_disconnect).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        ((DeviceActionListener) getActivity()).disconnect();
                    }
                });


        mContentView.findViewById(R.id.btn_send_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainApp.fc != null) {
                    JSONArray fmAnthro = db.getAnthroFamilyMembers();
                    if (fmAnthro != null && fmAnthro.length() > 0) {
                        Intent serviceIntent = new Intent(getActivity(), DataTransferService.class);
                        serviceIntent.setAction(DataTransferService.ACTION_SEND_DATA);
                        serviceIntent.putExtra("Type", "Anthro");
                        serviceIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(db.getAnthroFamilyMembers()));
                        serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_ADDRESS,
                                info.groupOwnerAddress.getHostAddress());
                        serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_PORT, 8988);
                        getActivity().startService(serviceIntent);
                    } else {
                        Toast.makeText(getActivity(), "No family members eligible for Anthropometry in this household", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(getActivity(), "No family member data exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mContentView.findViewById(R.id.btn_send_cluster_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MainApp.fc != null) {
                    JSONArray fmAnthro = db.getAnthroFamilyMembers();
                    if (fmAnthro != null && fmAnthro.length() > 0) {
                        Intent serviceIntent = new Intent(getActivity(), DataTransferService.class);
                        serviceIntent.setAction(DataTransferService.ACTION_SEND_DATA);
                        serviceIntent.putExtra("Type", "Anthro");
                        serviceIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(db.getAnthroFamilyMembers()));
                        serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_ADDRESS,
                                info.groupOwnerAddress.getHostAddress());
                        serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_PORT, 8988);
                        getActivity().startService(serviceIntent);
                    } else {
                        Toast.makeText(getActivity(), "No family members eligible for Anthropometry in this household", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "No family member data exists", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mContentView.findViewById(R.id.btn_send_comp_Forms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                JSONArray formsCom = db.getCompleteForms();
                if (formsCom != null && formsCom.length() > 0) {
                    Intent serviceIntent = new Intent(getActivity(), DataTransferService.class);
                    serviceIntent.setAction("edu.aku.hassannaqvi.nns_2018.WifiDirect.SEND");
                    serviceIntent.putExtra("Type", "CompForms");
                    serviceIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(db.getCompleteForms()));
                    serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_ADDRESS,
                            info.groupOwnerAddress.getHostAddress());
                    serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_PORT, 8988);
                    getActivity().startService(serviceIntent);
                } else {
                    Toast.makeText(getActivity(), "No 'Complete' Forms exist in this device", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return mContentView;
    }

    public void sendAnthro(View v) {
        Intent serviceIntent = new Intent(getActivity(), DataTransferService.class);
        serviceIntent.setAction(DataTransferService.ACTION_SEND_DATA);
        serviceIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(db.getAnthroFamilyMembers()));
        serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_ADDRESS,
                info.groupOwnerAddress.getHostAddress());
        serviceIntent.putExtra(DataTransferService.EXTRAS_GROUP_OWNER_PORT, 8988);
        getActivity().startService(serviceIntent);
    }

    @Override
    public void onConnectionInfoAvailable(final WifiP2pInfo info) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        this.info = info;
        this.getView().setVisibility(View.VISIBLE);

        // The owner IP is now known.
        TextView view = mContentView.findViewById(R.id.group_owner);
        view.setText(getResources().getString(R.string.group_owner_text)
                + ((info.isGroupOwner == true) ? getResources().getString(R.string.no)
                : getResources().getString(R.string.yes)));

        // InetAddress from WifiP2pInfo struct.
        view = mContentView.findViewById(R.id.device_info);
        view.setText("Group Owner IP - " + info.groupOwnerAddress.getHostAddress());

        // After the group negotiation, we assign the group owner as the file
        // server. The file server is single threaded, single connection server
        // socket.
        if (info.groupFormed && info.isGroupOwner) {
            new transferAnthro(getActivity(), mContentView.findViewById(R.id.status_text))
                    .execute();
        } else if (info.groupFormed) {
            // The other device acts as the client. In this case, we enable the
            // get file button.
            mContentView.findViewById(R.id.btn_send_msg).setVisibility(View.VISIBLE);
            ((TextView) mContentView.findViewById(R.id.status_text)).setText(getResources()
                    .getString(R.string.client_text));
        }

        // hide the connect button
        mContentView.findViewById(R.id.btn_connect).setVisibility(View.GONE);
    }

    /**
     * Updates the UI with device data
     *
     * @param device the device to be displayed
     */
    public void showDetails(WifiP2pDevice device) {
        this.device = device;
        this.getView().setVisibility(View.VISIBLE);
        TextView view = mContentView.findViewById(R.id.device_info);
        view.setText(device.toString());

    }

    /**
     * Clears the UI fields after a disconnect or direct mode disable operation.
     */
    public void resetViews() {
        mContentView.findViewById(R.id.btn_connect).setVisibility(View.VISIBLE);
        TextView view = mContentView.findViewById(R.id.device_info);
        view.setText(R.string.empty);
        view = mContentView.findViewById(R.id.group_owner);
        view.setText(R.string.empty);
        view = mContentView.findViewById(R.id.status_text);
        view.setText(R.string.empty);
        mContentView.findViewById(R.id.btn_send_msg).setVisibility(View.GONE);
        this.getView().setVisibility(View.GONE);
    }

    /**
     * A simple server socket that accepts connection and writes some data on
     * the stream.
     */
   /* public static class FileServerAsyncTask extends AsyncTask<Void, Void, String> {

        private Context context;
        private TextView statusText;

        *//**
     * @param context
     * @param statusText
     *//*
        public FileServerAsyncTask(Context context, View statusText) {
            this.context = context;
            this.statusText = (TextView) statusText;
            this.statusText.setText(null);

        }

        @Override
        protected String doInBackground(Void... params) {
            String line = "No Response";

            try {
                ServerSocket serverSocket = new ServerSocket(8988);
                Log.d(WiFiDirectActivity.TAG, "Server: Socket opened");
                Socket client = serverSocket.accept();
                Log.d(WiFiDirectActivity.TAG, "Server: connection done");
                *//*final File f = new File(Environment.getExternalStorageDirectory() + "/"
                        + context.getPackageName() + "/wifip2pshared-" + System.currentTimeMillis()
                        + ".jpg");

                File dirs = new File(f.getParent());
                if (!dirs.exists())
                    dirs.mkdirs();
                f.createNewFile();
*//*
                //Log.d(WiFiDirectActivity.TAG, "server: copying files " + f.toString());
                InputStream inputstream = client.getInputStream();
                //copyFile(inputstream, new FileOutputStream(f));
                serverSocket.close();
                //return f.getAbsolutePath();
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        inputstream, "utf-8"));
                StringBuffer sb = new StringBuffer();

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("" + sb.toString());
                return sb.toString();
            } catch (IOException e) {
                Log.e(WiFiDirectActivity.TAG, e.getMessage());
                return null;
            }
        }

        *//*
     * (non-Javadoc)
     * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
     *//*
        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                String json = result;
                if (json.length() > 0) {
                    DatabaseHelper db = new DatabaseHelper(context);
                    try {
                        JSONArray jsonArray = new JSONArray(json);
                        db.syncAnthroFromDevice(jsonArray);
                        statusText.setText("Message - " + jsonArray.length() + " Members for Anthro Received..");
                        Toast.makeText(context, jsonArray.length() + " Members for Anthro Received..", Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }

        }

        *//*
     * (non-Javadoc)
     * @see android.os.AsyncTask#onPreExecute()
     *//*
        @Override
        protected void onPreExecute() {
            statusText.setText("Opening a server socket");
        }

    }*/

}