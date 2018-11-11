package studios.fyhrf.hairdew;


import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fyhrf on 3/24/2018.
 */

public class BuildProductActivity extends AppCompatActivity {
    static private float price;
    Button submitOrderSumButton;

    String waterCost = "FREE";
    String roseWaterCost = "$3";
    String GlycerineCost = "$3";
    String AloeVeraCost = "$3";
    String teaTreeOilCost = "$3";
    String herbalSheaButterCost = "$10";
    String whiteSheaButterCost = "$8";
    String oliveOilCost = "$5";
    String babassuOilCost = "5";
    String jojobaOilCost = "$5";
    String coconutOilCost = "$5";
    String grapeseedOilCost = "$5";
    String jamaicanBlackCasterOilCost = "$5";
    String vanillaCost = "$3";
    String lavenderOilCost = "$3";
    String peppermintOilCost = "$3";
    String AlmondOilCost = "$3";
    String MurumuruButterCost = "$8";
    String VanillaExtractCost = "$3";
    String LavenderExtractCost = "$3";
    String PeppermintExtractCost = "$3";


    float fWaterCost = 0;
    float fRoseWaterCost = 3;
    float fWhiteSheaButterCost = 8;
    float fOliveOilCost = 5;
    float fBabassuOilCost = 5;
    float fJojobaOilCost = 5;
    float fCoconutOilCost = 5;
    float fGrapeseedOilCost = 5;
    float fherbalSheaButterCost = 10;
    float fJamaicanBlackCasterOilCost = 5;
    float fVanillaCost = 3;
    float fLavenderOilCost = 3;
    float fPeppermintOilCost = 3;
    float fTeaTreeOilCost = 3;
    float fGlycerineCost = 3;
    float fAloeVeraCost = 3;
    float fAlmondOilCost = 3;
    float fMurumuruButter = 8;
    float fFVanillaCost = 3;
    float fFLavenderCost = 3;
    float fFPeppermintOilCost = 3;


    public List<CheckBox> checkBoxList;
    public boolean [] array = new boolean[21];
    public List<Float> prices;
    private float total=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_product);
        //Array of check boxes
        checkBoxList = new ArrayList<>();
        checkBoxList.add((CheckBox)findViewById(R.id.water_water));
        checkBoxList.add((CheckBox)findViewById(R.id.rose_water));
        checkBoxList.add((CheckBox)findViewById(R.id.glycerine));
        checkBoxList.add((CheckBox)findViewById(R.id.aloeVera));
        checkBoxList.add((CheckBox)findViewById(R.id.teatree_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.peppermint_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.lavender_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.almond_Oil));
        checkBoxList.add((CheckBox)findViewById(R.id.vanilla));
        checkBoxList.add((CheckBox)findViewById(R.id.olive_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.babassu_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.coconut_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.grapeseed_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.herbal_shea_butter));
        checkBoxList.add((CheckBox)findViewById(R.id.white_Shea_Butter));
        checkBoxList.add((CheckBox)findViewById(R.id.murumuruButter));
        checkBoxList.add((CheckBox)findViewById(R.id.jojoba_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.jamaican_black_castor_oil));
        checkBoxList.add((CheckBox)findViewById(R.id.van));
        checkBoxList.add((CheckBox)findViewById(R.id.laven));
        checkBoxList.add((CheckBox)findViewById(R.id.pepp));



        //Array of product prices
        prices = new ArrayList<>();
        prices.add(fWaterCost);
        prices.add(fRoseWaterCost);
        prices.add(fGlycerineCost);
        prices.add(fAloeVeraCost);
        prices.add(fTeaTreeOilCost);
        prices.add(fPeppermintOilCost);
        prices.add(fLavenderOilCost);
        prices.add(fAlmondOilCost);
        prices.add(fVanillaCost);
        prices.add(fOliveOilCost);
        prices.add(fBabassuOilCost);
        prices.add(fCoconutOilCost);
        prices.add(fGrapeseedOilCost);
        prices.add(fherbalSheaButterCost);
        prices.add(fWhiteSheaButterCost);
        prices.add(fMurumuruButter);
        prices.add(fJojobaOilCost);
        prices.add(fJamaicanBlackCasterOilCost);
        prices.add(fFVanillaCost);
        prices.add(fFLavenderCost);
        prices.add(fFPeppermintOilCost);


        UI();

        priceViews();

        events();



    }
    public void UI(){
        submitOrderSumButton = findViewById(R.id.create_order_summary_button);
        submitOrderSumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(BuildProductActivity.this, SubmitActivity.class);
                intent.putExtra("storedChecks", array);
                startActivity(intent);
            }
        });
    }

    private void events(){

        for (final CheckBox checkbox:checkBoxList) {
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    checkTotalPrice();
                }
            });
        }

    }

    private void checkTotalPrice() {

        total=0;
        int position;
        for (final CheckBox checkbox:checkBoxList) {
            position=checkBoxList.indexOf(checkbox);
            if(checkbox.isChecked()){
                total+=prices.get(position);
            }
        }

        Log.v("CONSOLE","total price is "+total);

        ((TextView)findViewById(R.id.order_sum)).setText("Total :$ "+total);
    }



    //This method displays the prices of the products
    public void priceViews (){

        Ingredients ingredients1 = new Ingredients();
        ingredients1.setName("Water");
        ingredients1.setPrice(waterCost);

        Ingredients ingredients1A = new Ingredients();
        ingredients1A.setName("Raw Shea Butter");
        ingredients1A.setPrice(herbalSheaButterCost);

        Ingredients ingredients1B = new Ingredients();
        ingredients1B.setName("White Shea Butter");
        ingredients1B.setPrice(whiteSheaButterCost);

        Ingredients ingredients2A = new Ingredients();
        ingredients2A.setName("Jojoba Oil");
        ingredients2A.setPrice(jojobaOilCost);

        Ingredients ingredients2B = new Ingredients();
        ingredients2B.setName("Coconut Oil");
        ingredients2B.setPrice(coconutOilCost);

        Ingredients ingredients2C = new Ingredients();
        ingredients2C.setName("Grapeseed Oil");
        ingredients2C.setPrice(grapeseedOilCost);

        Ingredients ingredients2D = new Ingredients();
        ingredients2D.setName("Jamaican Back Castor Oil");
        ingredients2D.setPrice(jamaicanBlackCasterOilCost);

        Ingredients ingredients3A = new Ingredients();
        ingredients3A.setName("Rose Water");
        ingredients3A.setPrice(roseWaterCost);

        Ingredients ingredients3B = new Ingredients();
        ingredients3B.setName("Vanilla");
        ingredients3B.setPrice(vanillaCost);

        Ingredients ingredients3C = new Ingredients();
        ingredients3C.setName("Lavender Oil");
        ingredients3C.setPrice(lavenderOilCost);

        Ingredients ingredients3D = new Ingredients();
        ingredients3D.setName("Tea Tree Oil");
        ingredients3D.setPrice(teaTreeOilCost);

        Ingredients ingredients3E = new Ingredients();
        ingredients3E.setName("Peppermint Oil");
        ingredients3E.setPrice(peppermintOilCost);

        Ingredients ingredients4A = new Ingredients();
        ingredients4A.setName("Glycerine");
        ingredients4A.setPrice(GlycerineCost);

        Ingredients ingredients4B = new Ingredients();
        ingredients4B.setName("Aloe Vera");
        ingredients4B.setPrice(AloeVeraCost);

        Ingredients ingredients4C = new Ingredients();
        ingredients4C.setName("Almond Oil");
        ingredients4C.setPrice(AlmondOilCost);

        Ingredients ingredients4D = new Ingredients();
        ingredients4D.setName("Murumuru Butter");
        ingredients4D.setPrice(MurumuruButterCost);

        Ingredients ingredients4F = new Ingredients();
        ingredients4F.setName("Olive Oil");
        ingredients4F.setPrice(oliveOilCost);

        Ingredients ingredients4G = new Ingredients();
        ingredients4G.setName("Babassu Oil");
        ingredients4G.setPrice(babassuOilCost);

        Ingredients ingredients5A = new Ingredients();
        ingredients5A.setPrice(VanillaExtractCost);

        Ingredients ingredients5B = new Ingredients();
        ingredients5B.setPrice(LavenderExtractCost);

        Ingredients ingredients5C = new Ingredients();
        ingredients5C.setPrice(PeppermintExtractCost);



        TextView waterTextView = (TextView) findViewById(R.id.water_Price);
        waterTextView.setText(ingredients1.getPrice());

        TextView rSTextView = (TextView) findViewById(R.id.herbal_shea_butterPrice);
        rSTextView.setText(ingredients1A.getPrice());

        TextView wSTextView = (TextView) findViewById(R.id.white_shea_butterPrice);
        wSTextView.setText(ingredients1B.getPrice());

        TextView oliveOilTextView = (TextView) findViewById(R.id.olive_oil_Price);
        oliveOilTextView.setText(ingredients2A.getPrice());

        TextView babassuOilTextView = (TextView) findViewById(R.id.babassu_oil_Price);
        babassuOilTextView.setText(ingredients2A.getPrice());

        TextView jojobaOilTextView = (TextView) findViewById(R.id.jojoba_oilPrice);
        jojobaOilTextView.setText(ingredients2A.getPrice());

        TextView coconutOilTextView = (TextView) findViewById(R.id.coconut_oilPrice);
        coconutOilTextView.setText(ingredients2B.getPrice());

        TextView grapeseedOilTextView = (TextView) findViewById(R.id.grapeseed_oilPrice);
        grapeseedOilTextView.setText(ingredients2C.getPrice());

        TextView jamaicanOilTextView = (TextView) findViewById(R.id.jamaican_black_castor_oilPrice);
        jamaicanOilTextView.setText(ingredients2D.getPrice());

        TextView roseWaterTextView = (TextView) findViewById(R.id.rose_waterPrice);
        roseWaterTextView.setText(ingredients3A.getPrice());

        TextView vanillaTextView = (TextView) findViewById(R.id.vanilla_Price);
        vanillaTextView.setText(ingredients3B.getPrice());

        TextView lavenderOilTextView = (TextView) findViewById(R.id.lavender_oilPrice);
        lavenderOilTextView.setText(ingredients3C.getPrice());

        TextView peppermentOilTextView = (TextView) findViewById(R.id.peppermint_oilPrice);
        peppermentOilTextView.setText(ingredients3D.getPrice());

        TextView teatreeOilTextView = (TextView) findViewById(R.id.teatree_oilPrice);
        teatreeOilTextView.setText(ingredients3E.getPrice());

        TextView glycerineTextView = (TextView) findViewById(R.id.glycerine_Price);
        glycerineTextView.setText(ingredients4A.getPrice());

        TextView aloeVeraTextView = (TextView) findViewById(R.id.aloeVera_Price);
        aloeVeraTextView.setText(ingredients4B.getPrice());

        TextView AlmondOilTextView = (TextView) findViewById(R.id.almond_Oil_Price);
        AlmondOilTextView.setText(ingredients4C.getPrice());

        TextView murumuruButterTextView = (TextView) findViewById(R.id.murumur_butterPrice);
        murumuruButterTextView.setText(ingredients4D.getPrice());

        TextView Vanilla2TextView = (TextView) findViewById(R.id.vanillaP);
        Vanilla2TextView.setText(ingredients5A.getPrice());

        TextView LavenderOil2TextView = (TextView) findViewById(R.id.lavenP);
        LavenderOil2TextView.setText(ingredients5B.getPrice());

        TextView PeppermintOil2TextView = (TextView) findViewById(R.id.peppP);
        PeppermintOil2TextView.setText(ingredients5C.getPrice());






    }

}
