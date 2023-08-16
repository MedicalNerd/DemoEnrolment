package sg.edu.rp.c346.id22021421.demoenrolment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.entity.mime.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvEnrol;
    AsyncHttpClient client;
    ArrayAdapter<Enrolment> adapterLv;
    ArrayList<Enrolment> alEnrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvEnrol = findViewById(R.id.lvEnrol);
        client = new AsyncHttpClient();
        alEnrol = new ArrayList<>();
        adapterLv = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alEnrol);
        lvEnrol.setAdapter(adapterLv);
    }

    @Override
    protected void onResume() {
        super.onResume();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42&limit=5", new JsonHttpResponseHandler() {
            String year;
            String study;
            int enrolment;

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrRecords = response.getJSONObject("result").getJSONArray("records");
                    for (int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjEnrolment = jsonArrRecords.getJSONObject(i);
                        year = jsonObjEnrolment.getString("year");
                        study = jsonObjEnrolment.getString("type_of_study");
                        enrolment = jsonObjEnrolment.getInt("enrolment");

                        Enrolment enrolments = new Enrolment(year, study, enrolment);
                        alEnrol.add(enrolments);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Code to display List View

                adapterLv.notifyDataSetChanged();
            }







        });
    }
}
