<template>
    <div>
        <String label="수주 번호" v-model="value.salesOrderNumber" :editMode="editMode"/>
        <String label="수주 담당자" v-model="value.salesPerson" :editMode="editMode"/>
        <String label="수주상태" v-model="value.status" :editMode="editMode"/>
        <SalesType offline label="수주유형" v-model="value.salesType" :editMode="editMode" @change="change"/>
        <CompanyId offline label="회사명" v-model="value.companyId" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from '../base-ui/BaseEntity.vue'
import String from '../primitives/String.vue'
import CompanyId from '../CompanyId.vue'
import SalesType from '../SalesType.vue'

export default {
    name: 'SalesOrder',
    mixins:[BaseEntity],
    components:{
        String,
        CompanyId,
        SalesType
    },
    
    data: () => ({
        path: "salesOrders"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

