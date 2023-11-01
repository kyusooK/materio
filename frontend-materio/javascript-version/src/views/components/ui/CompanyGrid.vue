<template>
    <v-col :cols="2">
      <DrawerContent/>
    </v-col>
    <v-col :cols="10">
        <v-row>
            <!-- <UserProfile style="right: 2px;"/> -->
        </v-row>
      <div style="max-height:80vh; margin-top: 90px;">
          <!-- Recent Transactions -->
          <div class="panel">
              <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                  <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                      <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                  </v-btn>
              </div>
              <div class="mb-5 text-lg font-bold">Recent Transactions</div>
              <div class="table-responsive">
                  <v-table>
                      <thead>
                          <tr >
                              <th>id</th>
                              <th>NAME</th>
                              <th>INDUSTRY</th>
                              <th>CODENUM</th>
                              <th>WEHATER</th>
                              <th></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)">
                              <td class="font-semibold">#{{ idx + 1 }}</td>
                              <td class="whitespace-nowrap">{{val.name}}</td>
                              <td class="whitespace-nowrap">{{val.industry}}</td>
                              <td class="whitespace-nowrap">{{val.codeNum}}</td>
                              <td class="whitespace-nowrap">
                                <Weather :editMode="false" :inList="true" v-model="val.weather"></Weather>
                              </td>
                              <td class="whitespace-nowrap"></td>
                              <td class="whitespace-nowrap">
                                  <Icon icon="mi:delete" @click="deleteRow(val)" />
                              </td>
                          </tr>
                      </tbody>
                  </v-table>
              </div>
          </div>
          <v-col>
              <v-dialog
                  v-model="openDialog"
                  transition="dialog-bottom-transition"
                  width="35%"
              >
                  <v-card>
                      <v-toolbar
                          color="primary"
                          class="elevation-0"
                          height="50px"
                      >
                          <div style="color:white; font-size:17px; font-weight:700;">Company 등록</div>
                          <v-spacer></v-spacer>
                          <v-icon
                              color="white"
                              small
                              @click="closeDialog()"
                          >mdi-close</v-icon>
                      </v-toolbar>
                      <v-card-text>
                          <Company :offline="offline"
                              :isNew="!value.idx"
                              :editMode="true"
                              :inList="false"
                              v-model="newValue"
                              @add="append"
                          />
                      </v-card-text>
                  </v-card>
              </v-dialog>
          </v-col>
          <v-col style="margin-bottom:40px;">
              <div class="text-center">
                  <v-dialog
                      width="332.5"
                      fullscreen
                      hide-overlay
                      transition="dialog-bottom-transition"
                  >
                      <v-btn
                          style="position:absolute; top:2%; right:2%"
                          @click="closeDialog()"
                          depressed
                          icon 
                          absolute
                      >
                          <v-icon>mdi-close</v-icon>
                      </v-btn>
                  </v-dialog>
              </div>
          </v-col>
      </div>
    </v-col>
</template>

<script>

import BaseGrid from '../base-ui/BaseGrid.vue'
import Company from './Company.vue';
import DrawerContent from '../../../layouts/components/DrawerContent.vue';
import Weather from '../vo/Weather.vue'


// import UserProfile from '../../../layouts/components/UserProfile.vue'
import { ref } from 'vue';
import { useTheme } from 'vuetify';

export default {
    name: 'CompanyGrid',
    mixins:[BaseGrid],
    components:{
        Company,
        DrawerContent,
        Weather
    },
    data: () => ({
        path: "companies",
    }),
}

</script>