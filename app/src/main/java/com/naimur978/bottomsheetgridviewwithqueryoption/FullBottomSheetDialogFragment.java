package com.naimur978.bottomsheetgridviewwithqueryoption;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;


public class FullBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private BottomSheetBehavior mBehavior;

    private ItemAdapter adapter;
    private List<ModelClass> mModelClassList;
    private List<ModelClass> mSearchList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModelClassList = createItems();
        mSearchList = createItems();
        adapter = new ItemAdapter(mSearchList);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.bottom_sheet_layout, null);

        LinearLayout linearLayout = view.findViewById(R.id.root);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        //params.height = getScreenHeight();
        linearLayout.setLayoutParams(params);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        EditText editTextSearch = view.findViewById(R.id.editTextSearch);
        editTextSearch.addTextChangedListener(textWatcher);

        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public List<ModelClass> createItems() {
        ArrayList<ModelClass> items = new ArrayList<>();
        items.add(new ModelClass("Bird Flu", R.drawable.birdflu));
        items.add(new ModelClass("Corona", R.drawable.corona));
        items.add(new ModelClass("Crimean Congo", R.drawable.crimeancongo));
        items.add(new ModelClass("Dengue", R.drawable.dengue));
        items.add(new ModelClass("Ebola", R.drawable.ebola));
        items.add(new ModelClass("Hanta", R.drawable.hanta));
        items.add(new ModelClass("Lassa", R.drawable.lassa));
        items.add(new ModelClass("Machupo", R.drawable.machupo));
        items.add(new ModelClass("Marburg", R.drawable.marburg));
        items.add(new ModelClass("WestNile", R.drawable.westnile));
        items.add(new ModelClass("Ebola", R.drawable.ebola));
        items.add(new ModelClass("Hanta", R.drawable.hanta));
        items.add(new ModelClass("Bird Flu", R.drawable.birdflu));
        items.add(new ModelClass("Crimean Congo", R.drawable.crimeancongo));
        items.add(new ModelClass("Dengue", R.drawable.dengue));
        items.add(new ModelClass("Corona", R.drawable.corona));
        return items;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void afterTextChanged(Editable s) {
            search(s.toString().toLowerCase());
        }

    };

    private void search(String searchTerm){
        mSearchList.clear();
        for (ModelClass item : mModelClassList){
            if (item.name.toLowerCase().contains(searchTerm)){
                mSearchList.add(item);
            }
        }

        adapter.notifyDataSetChanged();

    }


}
