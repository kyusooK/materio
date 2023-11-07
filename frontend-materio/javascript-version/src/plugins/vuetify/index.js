import { createVuetify } from 'vuetify'
import defaults from './defaults'
import { icons } from './icons'
import theme from './theme'

// Styles
import '@core/scss/libs/vuetify/index.scss'
import 'vuetify/styles'
import { VDatePicker } from 'vuetify/lib/labs/components.mjs'
export default createVuetify({
  defaults,
  icons,
  theme,
  VDatePicker,
})
