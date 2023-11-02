<template>
    <div class="panel" style="margin-top: 40px;">
        <div class="label-title">{{label}}</div>
        <div class="table-responsive">
            <v-btn v-if="editMode" @click="addDetailRow()">추가</v-btn>
            <v-btn v-if="editMode" style="margin-left: 3px;" @click="detailDeleteRow()">삭제</v-btn>
            <v-table v-if="!editMode">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Qty</th>
                        <th>CompanyId</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(detailVal, idx) in selectedRow.salesItem" :key="detailVal" >
                        <td class="font-semibold">#{{ idx + 1 }}</td>
                        <td class="whitespace-nowrap">{{detailVal.qty}}</td>
                        <td class="whitespace-nowrap">
                            <CompanyId v-model="detailVal.companyId" :editMode="editMode"/>
                        </td>
                        <td class="whitespace-nowrap">
                            <Icon icon="mi:delete" @click="deleteRow(detailVal)" />
                        </td>
                    </tr>
                </tbody>
            </v-table>
            <v-table v-else>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Qty</th>
                        <th>CompanyId</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(addVal, idx) in newValue" :key="addVal" >
                        <td class="font-semibold">#{{ idx + 1 }}</td>
                        <td class="whitespace-nowrap">
                            <Number style="margin-left: -5px; width: 150px;" v-model="addVal.qty" :editMode="editMode"/>
                        </td>
                        <td class="whitespace-nowrap">
                            <CompanyId style="margin-left: -5px; width: 150px;" v-model="addVal.companyId" :editMode="editMode"/>
                        </td>
                        <td class="whitespace-nowrap"></td>
                        
                    </tr>
                </tbody>
            </v-table>
        </div>
    </div>
</template>
<script>
import BaseDetailGrid from '../base-ui/BaseDetailGrid.vue';
import Number from '../primitives/Number.vue'
import CompanyId from '../CompanyId.vue'

export default {
    name: 'SalesItemDetailGrid',
    mixins: [BaseDetailGrid],
    components: {
        Number,
        CompanyId
    },
    props: {
        label: String,
        editMode: Boolean,
        selectedRow: Object,
    },
    data: ()=>({
    }),
    created(){
    },
    methods: {
    }
}
</script>