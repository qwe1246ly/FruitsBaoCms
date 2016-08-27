package com.fruit.baocms.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fruit.baocms.R;
import com.fruit.baocms.adapter.FunctionListAdapter;
import com.fruit.baocms.adapter.OptionAdapter;
import com.fruit.baocms.widget.GridViewForScrollView;
import com.fruit.baocms.widget.ListViewForScrollView;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MineFragment extends Fragment {

    GridViewForScrollView mFunctionGv;
    ImageView mSetIv;
    LinearLayout mHeadLl;
    TextView mUserNameTv,mPhoneTv,mJifenTv,mYuErTv,mMoneyTv;
    ListViewForScrollView mOneLv,mTwoLv,mThreeLv;
    OptionAdapter functionAdapter;
    FunctionListAdapter oneListAdapter,twoListAdapter,threeListAdapter;
    RelativeLayout mLoginStatusRl;
    ImageView mHeadImgIv;
    String[] infos = new String[]{"我的抢购","我的购物","我的订餐","我的订座","我的云购","我的预约"};

    String[] oneInfos = new String[]{"我的抢购券","我的优惠券","优惠买单","我的活动"};
    String[] twoInfos = new String[]{"全民经纪人","积分兑换","我的快递"};
    String[] threeInfos = new String[]{"提现申请","消息中心","我的消息"};

    int[] oneImages = new int[]{R.mipmap.icon_panic_buy,R.mipmap.icon_discount,R.mipmap.icon_discount_buy,R.mipmap.icon_action
    };
    int[] twoImages = new int[]{R.mipmap.icon_agent,R.mipmap.icon_exchange,R.mipmap.icon_express};
    int[] threeImages = new int[]{R.mipmap.icon_money,R.mipmap.icon_msg,R.mipmap.icon_my_msg};

    int[] images = new int[]{R.mipmap.icon_qiang,R.mipmap.icon_shop,R.mipmap.icon_dingcan,
            R.mipmap.icon_dingzuo,R.mipmap.icon_yungou,R.mipmap.icon_yuyue};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine,null);
        initView(view);
        return view;

    }

    private void initView(View view) {

        mFunctionGv = (GridViewForScrollView) view.findViewById(R.id.mine_my_function);
        mSetIv = (ImageView) view.findViewById(R.id.mine_set);
        mHeadImgIv = (ImageView) view.findViewById(R.id.mine_headimg);

        mHeadLl = (LinearLayout) view.findViewById(R.id.mine_head);
        mUserNameTv = (TextView) view.findViewById(R.id.mine_username);
        mPhoneTv = (TextView) view.findViewById(R.id.mine_user_phone);
        mJifenTv = (TextView) view.findViewById(R.id.mine_jifen);
        mYuErTv = (TextView) view.findViewById(R.id.mine_yuer);
        mMoneyTv = (TextView) view.findViewById(R.id.mine_money);
        mOneLv =(ListViewForScrollView) view.findViewById(R.id.mine_function_one);
        mTwoLv =(ListViewForScrollView) view.findViewById(R.id.mine_function_two);
        mThreeLv =(ListViewForScrollView) view.findViewById(R.id.mine_function_three);
        mLoginStatusRl =(RelativeLayout) view.findViewById(R.id.mine_login_status);

        functionAdapter = new OptionAdapter(getActivity());
        functionAdapter.setOption(infos);
        functionAdapter.setImages(images);
        mFunctionGv.setAdapter(functionAdapter);

        oneListAdapter = new FunctionListAdapter(getActivity(),oneInfos);
        oneListAdapter.setImages(oneImages);
        oneListAdapter.setType(1);
        mOneLv.setAdapter(oneListAdapter);

        twoListAdapter = new FunctionListAdapter(getActivity(),twoInfos);
        twoListAdapter.setImages(twoImages);
        twoListAdapter.setType(2);
        mTwoLv.setAdapter(twoListAdapter);

        threeListAdapter = new FunctionListAdapter(getActivity(),threeInfos);
        threeListAdapter.setImages(threeImages);
        threeListAdapter.setType(3);
        mThreeLv.setAdapter(threeListAdapter);
//        mLoginStatusRl.setOnClickListener(this);
//        mSetIv.setOnClickListener(this);

        //  RefreshData();
//        if(UserInfos.getInstance().isExist()){
//            if(UserInfos.getInstance().loadAccount().token!=null){
//                RefreshData();
//            }
//        }

        mFunctionGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                switch (position) {
                    case 0:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/tuan/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 1:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/goods/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 2:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/eleorder/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 3:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/ding/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 4:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/cloud/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 5:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/yuyue/index/status/2.html");
//                            startActivity(i);
//                        }
                        break;
                    default:
                        break;
                }
            }
        });

        mOneLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                switch (position) {
                    case 0:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/tuancode/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 1:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/coupon/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 2:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/breaks/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 3:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/hdmobile/index.html");
//                            startActivity(i);
//                        }
                        break;

                    default:
                        break;
                }
            }
        });

        mTwoLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                switch (position) {
                    case 0:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mobile/extend/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 1:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/exchange/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 2:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/express/index.html");
//                            startActivity(i);
//                        }
                        break;
                    default:
                        break;
                }
            }
        });

        mThreeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                switch (position) {
                    case 0:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/cash/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 1:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), MessageActivity.class);
//                            i.putExtra("url", "/mcenter/message/index.html");
//                            startActivity(i);
//                        }
                        break;
                    case 2:
//                        if (Utils.isEmpty(Global.token)) {
//                            i.setClass(getActivity(), LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            i.setClass(getActivity(), CommonFirstActivity.class);
//                            i.putExtra("url", "/mcenter/msg/index.html");
//                            startActivity(i);
//                        }
                        break;
                    default:
                        break;
                }
            }
        });




    }

}
