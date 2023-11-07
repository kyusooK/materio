<template>
    <div>
        <String label="Code" v-model="value.code" :editMode="editMode"/>
        <String label="이름" v-model="value.name" :editMode="editMode"/>
        <String label="산업" v-model="value.industry" :editMode="editMode"/>
        <Date label="설립일자" v-model="value.foundedDate" :editMode="editMode"/>
        <Photo offline label="Photo" v-model="value.photo" :editMode="editMode" @change="change"/>
        <Weather offline label="Weather" v-model="value.weather" :editMode="editMode" @change="change"/>
        <Number label="코드번호" v-model="value.codeNum" :editMode="editMode"/>

        <v-divider class="border-opacity-100 my-divider" style="margin-top: 5px;"></v-divider>
        <v-layout row justify-end>
            <v-btn
                style="margin-top: 5px;"
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
import Number from '../primitives/Number.vue'
import Weather from '../vo/Weather.vue'

export default {
    name: 'Company',
    mixins:[BaseEntity],
    components:{
        String,
        Number,
        Weather,
    },
    
    data: () => ({
        path: "companies"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

